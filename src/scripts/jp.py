import sys

def main():
	x = sys.argv[len(sys.argv)-1]
	s = ""
	for i in range(1, len(sys.argv)-1):
		s = s+ str(sys.argv[i])
	a = str(s.replace('[', ""))
	b = str(a.replace(']', ""))
	b = b.split('{')
#	shops =  ',\"sid\":' + str(x) 
#	print x
	shops =  '{\"shopid\":' + str(x)
	ret = "{"+str(b[int(x)])
	re = str(ret.replace(shops, ""))
	print(re)

main()
