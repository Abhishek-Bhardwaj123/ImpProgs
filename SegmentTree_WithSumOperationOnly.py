# Here I suppose that node which does not have any value is represented by None.
# None+val <-- Error. Therefore, we create a different sum()
def sum(a, b):
    if a==None:
        if b==None:
            return None
        else:
            return b
    else:
        if b==None:
            return a
        else:
            return a+b

def buildTree(tree_arr, index, arr, start, end):
    if start==end:
        tree_arr[index] = arr[start]
        # As start==end, we also do
        # tree_arr[index] = arr[end]  (in place of line 17)
    elif start<end:
        # Here we create left and right children.
        # range(start, end) split into two parts.
        # range(start, mid)
        # range(mid+1, end)
        mid = (start+end)//2
        # 2*index gives left child of tree. This store range(start, mid).
        # 2*index+1 gives right child of tree. This store range(mid+1, end).
        buildTree(tree_arr, 2*index, arr, start, mid)
        buildTree(tree_arr, 2*index+1, arr, mid+1, end)
        left = tree_arr[2*index]
        right = tree_arr[2*index+1]
        tree_arr[index] = sum(left, right)
        # Note: tree-indexing starts from 1.
        # Because to apply formula:
        # 1. 2*index to get left child.
        # 2. 2*index+1 to get right child.
        # 3. However, original array range is 0 to len(arr)-1 inclsive.

def query(tree_arr, index, start, end, l, r):
    # (l, r): range given in question for which we want to get sum.
    # (start, end): (0, len(arr)-1), This represent range of original array.
    # tree_arr: tree array.
    # index: tree index (starting from 1).

    # Case 1: No overlap
    if start>r or end<l:
        pass
    # Case 2: Complete Overlap
    # (start, end) represent range in original array.
    # (l, r): query range.
    # l *---------* r
    # start *---* end
    # In above case, we return tree_arr[index] because some other child will return complete result.
    # Conclusion:
    #      l *------------------------------* r
    # start1 *------* end1
    #         start2 *--------------* end2
    #                         start3 *------* end3
    # In conclusion, we took 3 results. It can be more also.
    # But the thing to understand is that whenever we get a specific range lying inside completely l and r.
    # We simply return it. Atlast, we merge the result.
    elif start>=l and end<=r:
        return tree_arr[index]

    # Case 3: Partial Overlap
    #           l *--------------------* r
    # start *---------*end
    #                         start *---------* end
    else:
        mid = (start+end)//2
        left = query(tree_arr, 2*index, start, mid, l, r)
        right = query(tree_arr, 2*index+1, mid+1, end, l, r)
        return sum(left, right)

def updateNode(tree_arr, index, start, end, i, val):
    if i<start or i>end:
        pass
    elif start==end:
        tree_arr[index] = val
    else:
        mid = (start+end)//2
        updateNode(tree_arr, 2*index, start, mid, i, val)
        updateNode(tree_arr, 2*index+1, mid+1, end, i, val)
        tree_arr[index] = sum(tree_arr[2*index], tree_arr[2*index+1])

def updateRange(tree_arr, index, start, end, l, r, val):
    if start>r or end<l:
        pass
    elif start==end:
        tree_arr[index]+=val
    else:
        mid = (start+end)//2
        updateRange(tree_arr, 2*index, start, mid, l, r, val)
        updateRange(tree_arr, 2*index+1, mid+1, end, l, r, val)
        tree_arr[index] = sum(tree_arr[2*index], tree_arr[2*index+1])


if __name__=="__main__":
    arr = [3, 2, 4, 1]
    tree_arr = [None]*(4*len(arr)+1)
    index = 1
    start = 0
    end = len(arr)-1
    buildTree(tree_arr, 1, arr, 0, len(arr)-1)
    # for i in range(5):
    #     l, r = map(int, input().split())
    #     print(query(tree_arr, index, start, end, l, r))
    # updateNode(tree_arr, 1, start, end, 9, 6)
    # print(tree_arr)
    updateRange(tree_arr, index, start, end, 9, 9, 2)
    print(tree_arr)