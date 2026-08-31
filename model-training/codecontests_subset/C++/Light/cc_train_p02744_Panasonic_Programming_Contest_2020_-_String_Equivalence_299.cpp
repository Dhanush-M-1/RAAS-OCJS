#include <stdio.h>

int L; char A[12];

void go(int l, char e)
{
	if (l == L){
		puts(A);
		return;
	}

	for (char s = 'a'; s <= e; s++){
		A[l] = s;
		go(l + 1, e + (s == e));
	}
}

int main()
{
	scanf ("%d", &L);
	go(0,'a');

	return 0;
}