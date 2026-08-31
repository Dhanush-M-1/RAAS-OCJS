#include<bits/stdc++.h>
using namespace std;

typedef pair<int,int> pii;
const int N = 1e5;

int x;
int k;
int r[N+5];
int q;

vector<pii> lq;

int main(){
	scanf("%d",&x);
	scanf("%d",&k);
	for(int i=1;i<=k;i++){
		scanf("%d",&r[i]);
	}
	r[k+1] = (int) 1e9;
	scanf("%d",&q);
	for(int i=0;i<q;i++){
		int a,b;
		scanf("%d%d",&a,&b);
		lq.push_back(make_pair(a,b));
	}
	int id = 0;
	int baw = 0;
	int at = x;
	int ps = 0;
	int maksi = x;
	int mini = 0;
	int ibaw = 0;
	int iat = x;
	for(int i=1;i<=k+1;i++){
		int dif = r[i] - r[i-1];
		while(id < lq.size() && lq[id].first <= r[i]){
			int y = lq[id].second;
			int ans = y - ps;
			if(y <= baw){
				ans = ibaw;
			}
			if(y >= at){
				ans = iat;
			}
			if(i&1){
				ans -= lq[id].first - r[i-1];
			} else {
				ans += lq[id].first - r[i-1];
			}
			ans = max(0,ans);
			ans = min(ans,x);
//			if(!(i&1)) ans = x-ans;
			printf("%d\n",ans);
			id++;
		}
		if(i&1){
			ps+=dif;
			maksi-=dif;
			mini-=dif;
			ibaw-=dif;
			iat-=dif;
			if(ibaw < 0) ibaw = 0;
			if(iat < 0) iat = 0;
			if(mini < 0) baw -= mini, mini=0;
		} else {
			ps-=dif;
			maksi+=dif;
			mini+=dif;
			ibaw+=dif;
			iat+=dif;
			if(ibaw > x) ibaw = x;
			if(iat > x) iat = x;
			if(maksi > x) at -= maksi - x,maksi = x;
		}
//		cout << "baw " << baw << " and " << at << endl;
	}
	return 0;
}

/*

0 5 9 13 14 20

1-10, 1-5,

5,6,7,8,9,10

0,1,2,3,4,5 => 4,5,6,7,8,9

*/