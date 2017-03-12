from collections import Counter
import sys
def main():

	s = ""
	for i in range(len(sys.argv)):
		s = s + str( sys.argv[i])
	print (s.count('}'))
main()

