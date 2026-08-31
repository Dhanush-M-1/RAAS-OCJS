#include <bits/stdc++.h>
using namespace std;
using lint = long long;
using pi = pair<int, int>;
const int MAXN = 1000005;

int x, n;

int t[MAXN], p[MAXN], q[MAXN], l[MAXN];
int main(){
	scanf("%d %d",&x,&n);
	l[0] = x;
	for(int i=1; i<=n; i++){
		scanf("%d",&t[i]);
		int del = t[i] - t[i-1];
		tie(p[i], q[i], l[i]) = make_tuple(p[i-1], q[i-1], l[i-1]);
		if(i & 1){
			int dx = min(del, q[i]);
			q[i] -= dx;
			del -= dx;
			dx = min(del, l[i]);
			p[i] += dx;
			l[i] -= dx;
		}
		else{
			int dx = min(del, x - q[i] - l[i]);
			q[i] += dx;
			del -= dx;
			dx = min(del, l[i]);
			q[i] += dx;
			l[i] -= dx;
		}
	//	printf("%d %d %d\n", p[i], q[i], l[i]);
	}
	int qr;
	scanf("%d",&qr);
	for(int i=0; i<qr; i++){
		int ti, v; scanf("%d %d",&ti,&v);
		int pos= upper_bound(t, t + n + 1, ti) - t - 1;
		int now = 0;
		if(v <= p[pos]) now = q[pos];
		else now = q[pos] + min(l[pos], v - p[pos]);
		ti -= t[pos];
		if(pos % 2 == 0) now = max(0, now - ti);
		else now = min(x, now + ti);
		printf("%d\n", now);
	}

}

