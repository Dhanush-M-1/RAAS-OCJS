#include<bits/stdc++.h>
using namespace std;
int main()
{
	int t;
	cin>>t;
	int ac=0,wa=0,tle=0,re=0;
	while(t--){
		string s;
		cin>>s;
		if(s=="AC") ++ac;
		else if(s=="WA") ++wa;
		else if(s=="TLE") ++tle;
		else ++re;
	}
	cout<<"AC x "<<ac<<"\n"<<"WA x "<<wa<<"\n"<<"TLE x "<<tle<<"\n"<<"RE x "<<re;
	return 0;
}