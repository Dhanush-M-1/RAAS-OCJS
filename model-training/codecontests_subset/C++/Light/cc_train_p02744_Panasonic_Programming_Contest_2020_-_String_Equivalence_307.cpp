#include <bits/stdc++.h>

using namespace std;

int n;
char a[110];

void f(int here, int last)
{
	if(here == n)
	{
		printf("%s\n", a);
		return;
	}
	
	for(int i = 0 ; i <= last + 1 ; i++)
	{
		a[here] = i + 'a';
		f(here + 1, max(last, i));
	}
}

int main(void)
{
	scanf("%d", &n);
	
	f(0, -1);
	
	return 0;
}