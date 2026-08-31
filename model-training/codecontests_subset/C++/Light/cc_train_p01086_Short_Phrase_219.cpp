#include <bits/stdc++.h>
using namespace std;

int main(){
	int n;
	while(cin >> n and n){
		vector<int> v;
		for(int i = 0 ; i < n ; i++){
			string s;
			cin >> s;
			v.push_back(s.size());
		}
		for(int i = 0 ; i < n ; i++){
			int j = i;
			int s = 0;
			int f = 1;
			while( j < n and s < 5 ) s += v[j++];
			
			if( s != 5 ) f = 0;
			s = 0;
			while( j < n and s <7 ) s += v[j++];
			if( s != 7 ) f = 0;
			s = 0;
			while( j < n and s < 5 ) s += v[j++];
			if( s != 5 ) f = 0;
			s = 0;
			while( j < n and s < 7 ) s += v[j++];
			if( s != 7 ) f = 0;
			s = 0;
			
			while( j < n and s < 7) s += v[j++];
			if( s != 7 ) f = 0;
			
			if( f ){
				cout << i+1 << endl;
				break;
			}
		}
	}
}