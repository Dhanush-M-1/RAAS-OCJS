#include <iostream>
#include <cmath>
#include <cstdio>
using namespace std;
int N;
int a[100];
int b, c, d;
int main()
{
	cin >> N;
	for(int i=0; i<N; i++)
	{
		cin >> a[i];
	}
	d=0;
	for(int k=0; k<N-1; k++)
	{
		b=k;
		for(int i=k; i<N; i++)
		{
			if(a[i]<a[b])
			{
				b=i;
			}
		}
		if(k!=b)
		{
			c=a[b];
			a[b]=a[k];
			a[k]=c;
			d+=1;
		}
	}
	cout << a[0];
	for(int i=1; i<N; i++)
	{
		cout << " " << a[i];
	}
	cout << endl << d << endl;
	return 0;
}