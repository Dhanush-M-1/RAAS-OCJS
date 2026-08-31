#include<bits/stdc++.h>
using namespace std;
int n;
string s;
map<string,int> m;
int main(){
	cin>>n;
	for(int i=0;i<n;i++) {
		cin>>s;
		m[s]++;
	}
	cout<<"AC"<<" x "<<m["AC"]<<endl;
	cout<<"WA"<<" x "<<m["WA"]<<endl;
	cout<<"TLE"<<" x "<<m["TLE"]<<endl;
	cout<<"RE"<<" x "<<m["RE"];
	return 0;
}