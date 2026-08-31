#include<cstdio>
#include<algorithm>
using namespace std;
const int M = 100100;
int x, k, r[M], q, ans[M];
struct Query {
	int t, a, id;
}qry[M * 2];

bool cmp(Query a, Query b) {
	return a.t < b.t;
}

int main() {
	scanf("%d%d", &x, &k);
	for(int i = 1; i <= k; i++) {
		scanf("%d", &qry[i].t);
		qry[i].id = 0;
	}
	scanf("%d", &q);
	for(int i = 1; i <= q; i++) {
		scanf("%d%d", &qry[i + k].t, &qry[i + k].a);
		qry[i + k].id = i;
	}
	sort(qry + 1, qry + q + k + 1, cmp);
	int j = 1;
	int a = 0, a_len = 1, b = x, cge = -1;
	for(int i = 1; i <= q + k; i++) {
		int cp = qry[i].t - qry[i - 1].t;
		if(cge == -1) {
			if(cp > a) {
				a_len += cp - a;
				a = 0;
				
			} else a -= cp;
			b -= cp;
			if(a_len > x + 1) a_len = x + 1;
			if(b < 0) b = 0, a_len = x + 1;
			if(a < 0) a = 0;
		} else {
			a += cp;
			b += cp;
			if(b > x) b = x;
			if(a > x) a = x, a_len = x + 1;
		}
		if(qry[i].id == 0) cge = -cge; 
		else {
			//
			if(qry[i].a < a_len) ans[qry[i].id] = a;
			else if(qry[i].a < a_len + b - a) ans[qry[i].id] = qry[i].a - a_len + a + 1;
			else ans[qry[i].id] = b;
		}//printf("%d %d %d\n", a, a_len, b);
	}
	for(int i = 1; i <= q; i++) printf("%d\n", ans[i]);
	return 0;
}