#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int n;
void search(string s, char big)
{
	if(s.length()==n)
	cout<<s<<"\n";
	else
	{
		for(char c='a';c<big;c++)
		{
			
			search(s+c, big);
		}
		search(s+big, big+1);
	}
	
}
int main()
{
	
	cin>>n;
	string ans="";
	search(ans, 'a');
}	
	
