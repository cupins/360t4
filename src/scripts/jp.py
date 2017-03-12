import sys

def main():

	s = ""
	for i in range(1, len(sys.argv)-1):
		s = s+ str(sys.argv[i])
	a = str(s.replace('[', ""))
	b = str(b.replace(']', ""))
	b = b.split('{')
	x = sys.argv[len(sys.argv)-1]
#	print x
	
	ret = "{"+str(b[int(x)])
	print(ret)

main()
