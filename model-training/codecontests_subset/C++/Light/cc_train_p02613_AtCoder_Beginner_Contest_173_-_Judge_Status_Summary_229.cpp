#include<bits/stdc++.h>
using namespace std;
using ll = long long int;
ll n;
string k;
string bo[4]={"AC","WA","TLE","RE"};
int main()
{
	cin>>n;
	map<string,ll>kor;
	while(n--){
		cin>>k,kor[k]++;
	}
	for(string ki:bo){
	   cout<<ki<<" x "<<kor[ki]<<"\n";	
	}
}