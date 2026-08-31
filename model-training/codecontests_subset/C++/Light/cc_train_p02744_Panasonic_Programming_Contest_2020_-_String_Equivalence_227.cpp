#include<iostream>
using namespace std;

int n;
char a[19];

void Print()
{
	for(int i = 0;i<n;i++)cout << a[i];
	cout << endl;
}

void dfs(int x,int v)
{
	if(x==n)return Print();
	for(int i = 0;i<v;i++)
	{
		a[x] = 'a'+i;
		dfs(x+1,v);
	}
	a[x] = 'a'+v;
	dfs(x+1,v+1);
}

int main()
{
	cin >> n;
	a[0] = 'a';
	dfs(1,1);
	return 0;
}