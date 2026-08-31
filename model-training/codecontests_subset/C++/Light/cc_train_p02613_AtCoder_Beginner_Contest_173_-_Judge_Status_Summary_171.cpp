#include<bits/stdc++.h>
using namespace std;

int main() {
	long long int test,n,i,j,k,x,y,t;
	cin>>test;
	map<string,long>p;
	while(test--){
	 string s;
	 cin>>s;
	 p[s]++;
	    
	}
	cout<<"AC x "<<p["AC"]<<endl;
	cout<<"WA x "<<p["WA"]<<endl;
	cout<<"TLE x "<<p["TLE"]<<endl;
	cout<<"RE x "<<p["RE"]<<endl;
}
