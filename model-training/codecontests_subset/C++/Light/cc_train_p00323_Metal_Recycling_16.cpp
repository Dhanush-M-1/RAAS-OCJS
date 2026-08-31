#include <bits/stdc++.h>

typedef long long ll;
using namespace std;

typedef pair<int,int> P;

int n;
int x[100005],y[100005];

int ct(int a){
	int cnt = 0;
	while(a > 1){
		a /= 2;
		cnt++;
	}
	return cnt;
}


int main() {
	cin.tie(0);
	ios::sync_with_stdio(false);

	cin >> n;

	vector<P> a;

	for (int i = 0;i < n;i++){
		cin >> x[i] >> y[i];
		a.push_back(P(x[i]+y[i],1));
	}

	sort(a.begin(),a.end());

	while(true){
		vector<P> nex;
		nex.push_back(a[0]);
		for (int i = 1;i < a.size();i++){
			if(a[i] == a[i-1]){
				nex[nex.size()-1].second++;
			}else{
				nex.push_back(a[i]);
			}
		}
		bool flag = true;
		for (int i = 0;i < nex.size();i++){
			if(nex[i].second >= 2){
				int tmp = nex[i].second-(1<<ct(nex[i].second));
				if(tmp!=0)nex.push_back(P(nex[i].first,tmp));
				nex[i].first += ct(nex[i].second);
				nex[i].second = 1;
				flag = false;
			}
		}
		sort(nex.begin(),nex.end());
		a = nex;
	
		//for (int i = 0;i < a.size();i++){
		//	cout << a[i].first << " " << 0 << endl;
		//}
		//cout << endl;

		if(flag) break;
	}

	for (int i = 0;i < a.size();i++){
		cout << a[i].first << " " << 0 << endl;
	}

	return 0;

}

