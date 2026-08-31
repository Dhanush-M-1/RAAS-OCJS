#include<bits/stdc++.h>
using namespace std;
int main() {
	int n;
	map<string, int> cnt;
	string s;
	cin>>n;
	while (n--) {
		cin>>s;
		cnt[s]++;
	}

	cout<<"AC x "<<cnt["AC"]<<endl;
	cout<<"WA x "<<cnt["WA"]<<endl;
	cout<<"TLE x "<<cnt["TLE"]<<endl;
	cout<<"RE x "<<cnt["RE"]<<endl;
}