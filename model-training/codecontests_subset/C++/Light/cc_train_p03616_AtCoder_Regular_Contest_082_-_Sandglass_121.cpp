#include <cstdio>
#include <algorithm>
const int maxn = 1e5 + 5;
using namespace std;
struct QNode{
	int t, a, res, id;
	bool operator< (QNode x)const{
		return t < x.t || (t == x.t && a < x.a);
	}
}q[maxn]; int X, n, Q, r[maxn], opt = -1;
bool cmpid(QNode x, QNode y){
	return x.id < y.id;
}
int main(){
	scanf("%d%d", &X, &n); for (int i = 1; i <= n; i++) scanf("%d", r + i);
	scanf("%d", &Q); for (int i = 1; i <= Q; i++) scanf("%d%d", &q[i].t, &q[i].a), q[i].id = i;
	sort(q + 1, q + Q + 1);
	int lr = 0, lq = 1, u = X, d = 0, S = 0;
	while (lq <= Q){
		if (r[lr + 1] < q[lq].t && lr < n){
			++lr; int t = opt * (r[lr] - r[lr - 1]);
			d = max(0, min(X, d + t));
			u = max(0, min(X, u + t));
			S += t; opt *= -1;
		}
		else{
			q[lq].res = max(d, min(u, S + q[lq].a));
			q[lq].res = min(X, max(0, q[lq].res + opt * (q[lq].t - r[lr])));
			++lq;
		}
	} sort(q + 1, q + Q + 1, cmpid);
	for (int i = 1; i <= Q; i++) printf("%d\n", q[i].res);
	return 0;
}