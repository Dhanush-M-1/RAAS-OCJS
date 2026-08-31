#include <bits/stdc++.h>
using namespace std;

template <class T>
void readVector(int n, vector<T> &v){
	for(int i=0; i<n; ++i){
		T t;
		cin >> t;
		v.push_back(t);
	}
}

int a[5] = {5, 12, 17, 24, 31};
void solve(int n){
	vector<string> v;
	readVector(n, v);
	for(int i=0; i<n; ++i){
		int cnt = 0;
		int flag = 0;
		for(int j=i; j<n; ++j){
			cnt += v[j].size();
			for(int k=0; k<5; ++k)
				if(cnt == a[k])
					flag += (1 << k);
		}
		if(flag == 31){
			cout << i+1 << "\n";
			return;
		}
	}
}

int main(){
//	cin.tie(0);
//	ios::sync_with_stdio(false);
	while(1){
		int n;
		cin >> n;
		if(n == 0) return 0;
		solve(n);
	}
}
