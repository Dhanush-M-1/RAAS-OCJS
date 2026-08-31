#include<iostream>
#include<bits/stdc++.h>
#include<map>
#define ll long long int
using namespace std;
int main(){
	ll n;
	cin>>n;
	string s;
	map <string ,ll> m;
	while(n--){
		cin>>s;
		m[s]++;
	}
	cout<<"AC x "<<m["AC"]<<endl;
	cout<<"WA x "<<m["WA"]<<endl;
	cout<<"TLE x "<<m["TLE"]<<endl;
	cout<<"RE x "<<m["RE"]<<endl;
}