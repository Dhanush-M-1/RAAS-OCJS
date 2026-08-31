#include "bits/stdc++.h"
using namespace std;

string a;
map <string,int> m;
int n;

int main()
{
	cin>>n;
	while(n--) cin>>a,m[a]++;

	cout<<"AC x "<<m["AC"]<<endl;
	cout<<"WA x "<<m["WA"]<<endl;
	cout<<"TLE x "<<m["TLE"]<<endl;
	cout<<"RE x "<<m["RE"];
}