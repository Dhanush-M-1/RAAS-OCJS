#include<bits/stdc++.h>
using namespace std;
int n;
map<string,int>mp;
int main(){
	cin>>n;
	for(int i=0;i<n;i++){
		string s;cin>>s;
		mp[s]++;
	}
	cout<<"AC x "<<mp["AC"]<<"\n";
	cout<<"WA x "<<mp["WA"]<<"\n";
	cout<<"TLE x "<<mp["TLE"]<<"\n";
	cout<<"RE x "<<mp["RE"]<<"\n";
}