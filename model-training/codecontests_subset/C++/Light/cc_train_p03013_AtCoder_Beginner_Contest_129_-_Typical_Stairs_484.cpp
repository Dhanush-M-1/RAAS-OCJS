#include<bits/stdc++.h>
using namespace std;
map<int,int> blo;
int A[100005];
int main()
{
	int n,m;
	cin>>n>>m;
	for(int i=0;i<m;i++)
	{
		int a;
		cin>>a;
		blo[a] = 1;
	}
	A[0] = 1;
	for(int i=1;i<=n;i++)
	{
		if(!blo[i-1])
		{
			A[i] += A[i-1];
		}
		if(i-2>=0&&!blo[i-2])
			A[i] += A[i-2];
		A[i] = A[i]%(1000000007);
	}
	cout<<A[n]<<endl;
	return 0;
}