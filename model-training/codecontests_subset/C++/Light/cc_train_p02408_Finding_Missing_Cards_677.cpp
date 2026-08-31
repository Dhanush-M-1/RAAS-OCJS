#include<iostream>
using namespace std;
#include<string.h>
#include<stdio.h>
int main()
{
	char b, mark[]={"SHCD"};
	int a,i,m[4][14]={0},n,j;
	cin>>a;
	for(i=0;i<a;i++)
	{
		cin>>b>>n;
		if(b=='S')
		{
			m[0][n]=1;
		}
		if(b=='H')
		{
			m[1][n]=1;
		}
		if(b=='C')
		{
			m[2][n]=1;
		}
		if(b=='D')
		{
			m[3][n]=1;
		}
	}
	for(i=0;i<4;i++)
	{
		for(j=1;j<14;j++)
		{
			if(m[i][j]==0)
			{
				cout<<mark[i] <<" "<<j<<endl;
			}
		}
	}		
	return 0;
}