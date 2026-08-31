#include <bits/stdc++.h>
using namespace std;
 
 
 
int main() {
	vector<pair<int, int>> v;
	vector<pair<int, int>> c;
	int n, m;
	cin>>n>>m;
	while(n--){
		int x,y;
		cin>>x>>y;
		v.emplace_back(x,y);
	}
	
	while(m--){
		int x,y;
		cin>>x>>y;
		c.emplace_back(x,y);
	}
	
	for(auto& u:v){
		int min=1000000000;
		int count=0,t;
		for(auto& p:c){
			count++;
			int x=abs(u.first-p.first)+abs(u.second-p.second);
			if(x<min){
				min=x;
				t=count;
			}
		}
		cout<<t<<endl;
	}
	
}