#include<bits/stdc++.h>
using namespace std;
const int ms = 58;
int s[ms][2], c[ms][2];


int main(){
	int maxi = 0;
	int n,m;
	cin >> n >> m;
	for(int i = 0;i<n;i++) cin >> s[i][0] >> s[i][1];
	for(int i = 0;i<m;i++) cin >> c[i][0] >> c[i][1];
	
	for(int i = 0;i<n;i++){
		maxi = 0x3f3f3f3f;
		int id=0;
		for(int j =0 ;j<m;j++){
			int val = abs(s[i][0]-c[j][0]) + abs(s[i][1]-c[j][1]);
			if(val <maxi){
				maxi = val;
				id = j+1;
			}
		}
	cout<<id<<endl;
	
	}
	

}