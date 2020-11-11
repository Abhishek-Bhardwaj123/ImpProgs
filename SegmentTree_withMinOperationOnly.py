# Construction of Segment Tree using array of size 4*N+1

def min(a, b):
	if a==None:
		if b==None:
			return None
		else:
			return b
	else:
		if b==None:
			return a
		else:
			return a if a<b else b
			


def buildSegmentTree(tree_arr, tree_index, arr, start, end):
	if start==end:
		tree_arr[tree_index] = arr[start]  
	elif start<end:
		mid = (start+end)//2
		buildSegmentTree(tree_arr, 2*tree_index, arr, start, mid)
		buildSegmentTree(tree_arr, 2*tree_index+1, arr, mid+1, end)
		left = tree_arr[2*tree_index]
		right = tree_arr[2*tree_index+1]
		tree_arr[tree_index] = min(left, right)
	else:
		pass

def query(tree_arr, tree_index, start, end, query_left, query_right):
	if(start>query_right or end<query_left):
		return None
	elif(start>=query_left and end<=query_right):
		return tree_arr[tree_index]
	else:
		mid = (start+end)//2
		leftSubtree = query(tree_arr, 2*tree_index, start, mid, query_left, query_right)
		rightSubtree = query(tree_arr, 2*tree_index+1, mid+1, end, query_left, query_right)
		return min(leftSubtree, rightSubtree)


def updateNode(tree_arr, tree_index, start, end, index, val):
	if index<start or index>end:
		pass
	elif start==end:
		tree_arr[tree_index] = val
	else:
		mid = (start+end)//2
		updateNode(tree_arr, 2*tree_index, start, mid, index, val)
		updateNode(tree_arr, 2*tree_index+1, mid+1, end, index, val)
		left = tree_arr[2*tree_index]
		right = tree_arr[2*tree_index+1]
		tree_arr[tree_index] = min(left, right)

def updateRange(tree_arr, tree_index, start, end, range_start, range_end, inc_Val):
	if range_start>end or range_end<start:
		pass
	elif start==end:
		tree_arr[tree_index]+=inc_Val
	else:
		mid = (start+end)//2
		updateRange(tree_arr, 2*tree_index, start, mid, range_start, range_end, inc_Val)	
		updateRange(tree_arr, 2*tree_index+1, mid+1, end, range_start, range_end, inc_Val)
		left = tree_arr[2*tree_index]
		right = tree_arr[2*tree_index+1]
		tree_arr[tree_index] = min(left, right)

if __name__=="__main__":
	print("Enter list elements:")
	arr = list(map(int, input().split()))
	sizeOfTree = 4*len(arr)+1
	tree_arr = [None]*sizeOfTree 
	buildSegmentTree(tree_arr, 1, arr, 0, len(arr)-1)
	#for i in range(5):
	#	l, r = map(int, input().split())
	#	print(query(tree_arr, 1, 0, len(arr)-1, l, r))
	updateRange(tree_arr, 1, 0, len(arr)-1, 1, 2, 4)
	print(tree_arr)