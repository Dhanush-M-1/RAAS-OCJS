#include <bits/stdc++.h>
using namespace std;
set<pair<char,int> >s;
string str="SHCD";
int main(){
	// S H C D
	int n;cin>>n;
	char c;int k;
	for(int i=0;i<n;i++){
		cin>>c>>k;
		s.insert({c,k});
	}
	for(int i=0;i<str.length();i++){
		c=str[i];
		for(int j=1;j<=13;j++)
			if(s.find({c,j})==s.end())
				cout<<c<<' '<<j<<endl;
	}
	return 0;
}
