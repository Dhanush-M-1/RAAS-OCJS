#include<iostream>
using namespace std;
string T[4]={"AC","WA","TLE","RE"};
int cnt[4];
int main()
{
	int N;cin>>N;
	for(;N--;)
	{
		string s;cin>>s;
		for(int i=0;i<4;i++)if(T[i]==s)cnt[i]++;
	}
	for(int i=0;i<4;i++)cout<<T[i]<<" x "<<cnt[i]<<endl;
}
