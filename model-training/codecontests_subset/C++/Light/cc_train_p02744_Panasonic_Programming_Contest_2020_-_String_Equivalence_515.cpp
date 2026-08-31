#include<bits/stdc++.h>
using namespace std;
int n;
void dfs(string s,char watch)
{
	if(s.size()==n){
		cout<<s<<endl;
		return ;
	}
	for(char i='a';i<watch;i++)
		dfs(s+i,watch);
	dfs(s+watch,watch+1);
}
int main()
{
	cin>>n;
	dfs("",'a');
	return 0;
}