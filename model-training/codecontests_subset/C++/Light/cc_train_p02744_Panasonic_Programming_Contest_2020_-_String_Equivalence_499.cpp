#include<bits/stdc++.h>
using namespace std;
#define ll long long
int n;
void solve(char*a,int i, char c)
{
	if(i==n)
	{
		a[i]='\0';
		cout<<a<<endl;
		return;
	}
	for(char x='a';x<=c;x++)
	{
		a[i]=x;
		if(x==c)
			solve(a,i+1,c+1);
        else
        	solve(a,i+1,c);
	}
}
int main()
{
    cin>>n;
    char a[100];
    solve(a,0,'a');
}