#include<bits/stdc++.h>
using namespace std;
const int MAXN = 3e4 + 4;
typedef long long ll;
int p[MAXN];
ll ways[10][MAXN], L[10][MAXN], R[10][MAXN];
int T, c, n, q;
int main() {
	scanf("%d", &T);
	for(int kase = 1; kase <= T; kase++) {
		scanf("%d%d%d", &n, &c, &q);
		for(int i = 1; i <= n; i++) scanf("%d", &p[i]);
		for(int i = 0; i <= c; i++) {
			ways[i][n + 1] = 1;
			L[i][n + 1] = R[i][n + 1] = 0;
			for(int j = n; j; j--) {
				ways[i][j] = ways[i][j + 1], L[i][j] = L[i][j + 1], R[i][j] = R[i][j + 1];
				for(int k = 1; k <= i && j + k <= n; k++) {
					ways[i][j] += ways[i - k] [j + 1 + k];
					if(p[j] > p[j + k]) L[i][j] += ways[i - k][j + k + 1];
					else R[i][j] += ways[i - k][j + k + 1];
				}
			}
		}
		while(q--) {
			int pos; ll id;
			scanf("%d%lld", &pos, &id);
			if(id > ways[c][1]) { printf("-1\n"); continue;}
			int cur = 1, rem = c, ans;
			while(cur <= n) {
				int l = cur, r = n, m;
				while(l <= r) {
					int mid = (l + r) >> 1;
					if(L[rem][cur] - L[rem][mid] < id && R[rem][cur] - R[rem][mid] <= ways[rem][cur] - id) {
						l = (m = mid) + 1;
					} else {
						r = mid - 1;
					}
				}
				if(m > pos) { ans = pos; break;}
				id -= L[rem][cur] - L[rem][m]; cur = m;
				vector<int> order;
				for(int k = 0; k <= rem && cur + k <= n; k++) order.push_back(k);
				sort(order.begin(), order.end(), [&](int x, int y) { return p[cur + x] < p[cur + y];});
				int cost;
				for(int i : order) {
					if(id <= ways[rem - i][cur + i + 1]) { cost = i; break;}
					else id -= ways[rem - i][cur + i + 1];
				}
				if(cost + cur >= pos) { ans = cur * 2 - pos + cost; break;}
				rem -= cost, cur += cost + 1;
			}
			printf("%d\n", p[ans]);
		}
	}
	return 0;
}
	 	    				     		    		 				