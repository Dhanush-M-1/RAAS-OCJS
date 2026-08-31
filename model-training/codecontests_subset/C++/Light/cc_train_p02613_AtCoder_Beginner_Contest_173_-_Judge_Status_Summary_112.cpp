#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll n;
string stu[5]={"AC","WA","TLE","RE"};
string s;
ll num[5];
int main(){
	cin>>n;
	for(ll i=0;i<n;i++){
		cin>>s;
		for(ll j=0;j<4;j++)
			if(s==stu[j]) num[j]++;
	}
	for(ll i=0;i<4;i++)
		cout<<stu[i]<<" x "<<num[i]<<endl;
	return 0;
}