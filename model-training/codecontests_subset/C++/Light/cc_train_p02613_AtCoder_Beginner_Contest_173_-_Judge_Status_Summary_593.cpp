#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn=2e5+5; 


string s;
int main(){
	map<string,int>m;
	int n;
	cin>>n;
	while(n--){
		cin>>s;
		m[s]++;
	}
	cout<<"AC x "<<m["AC"]<<endl;
	cout<<"WA x "<<m["WA"]<<endl;
	cout<<"TLE x "<<m["TLE"]<<endl;
	cout<<"RE x "<<m["RE"];
	return 0;
}