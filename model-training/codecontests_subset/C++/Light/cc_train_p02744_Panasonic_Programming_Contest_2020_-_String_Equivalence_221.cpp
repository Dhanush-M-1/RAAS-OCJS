#include<iostream>
using namespace std;
int N;
void dfs(int id,string s,int ap)
{
	if(id==N)
	{
		cout<<s<<endl;
		return;
	}
	for(int i=0;i<=ap;i++)
	{
		string t=s;
		t+=(char)(i+'a');
		dfs(id+1,t,ap+(i==ap));
	}
}
int main()
{
	cin>>N;
	dfs(0,"",0);
}
