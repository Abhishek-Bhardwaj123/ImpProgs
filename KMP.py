def LPS(pattern):
	lps_table = [0]*len(pattern)
	i = 0
	j = 1
	while(j<len(pattern)):
		if pattern[i]==pattern[j]:
			lps_table[j] = i+1
			i+=1
			j+=1
		else:
			if i:
				i = lps_table[i-1]
			else:
				lps_table[j] = 0
				j+=1
	return lps_table

def KMP(text, pattern):
	lps_table = LPS(pattern)
	lps_table.insert(0,0)
	pattern = f"_{pattern}"
	i = 0
	j = 0
	count = 0
	while(i<len(text)):
		if pattern[j+1]==text[i]:    
			j+=1
			i+=1
			if j==len(pattern)-1:
				count+=1
				j = lps_table[j]
		else:
			if j:
				j = lps_table[j]
			else:
				i+=1
	return count

pattern = input()
text = input()
print(KMP(text, pattern))