#include <bits/stdc++.h>

using namespace std;

int main(){
	int n;
	cin>>n;
	unordered_map<string , int> c;
	while(n--){
		string s;
		cin>>s;
		c[s]++;
	}
	cout<<"AC x "<<c["AC"]<<endl<<"WA x "<<c["WA"]<<endl<<"TLE x "<<c["TLE"]<<endl<<"RE x "<<c["RE"]<<endl;
}