#include<cstdio>
//used segment tree to maintain point set
//0 for ai-d*i, 1 for ai+d*i
//a for visited, b for not
struct SegmentT{
	int l,r;
	int al,ar;
	int bl,br;
	int bestL, bestR;
	SegmentT(){
		l = r = 0;
		al = ar = bl = br = bestL = bestR = -1;
	}
};
SegmentT t[800005];
long long D;
long long a[200005];
int vis[200005];
const long long inf = 1e18+7;

long long getSingle(long long p,long long tag){
	if(p==-1) return inf;
	else return a[p]+tag*D*p;
}

long long getPair(long long l,long long r){
	if(l==-1 || r==-1) return inf;
	else return a[l]+a[r]+D*(r-l);
}

SegmentT merge(SegmentT a, SegmentT b){
	SegmentT res;
	res.l = a.l, res.r = b.r;
	if(getSingle(a.al,-1)<getSingle(b.al,-1)) res.al = a.al;
	else res.al = b.al;
	if(getSingle(a.ar,1)<getSingle(b.ar,1)) res.ar = a.ar;
	else res.ar = b.ar;
	if(getSingle(a.bl,-1)<getSingle(b.bl,-1)) res.bl = a.bl;
	else res.bl = b.bl;
	if(getSingle(a.br,1)<getSingle(b.br,1)) res.br = a.br;
	else res.br = b.br;
	if(getPair(a.bestL,a.bestR)<getPair(b.bestL,b.bestR)) res.bestL = a.bestL, res.bestR = a.bestR;
	else res.bestL = b.bestL, res.bestR = b.bestR;
	if(getPair(a.al,b.br)<getPair(res.bestL,res.bestR)) res.bestL = a.al, res.bestR = b.br;
	if(getPair(a.bl,b.ar)<getPair(res.bestL,res.bestR)) res.bestL = a.bl, res.bestR = b.ar;
	return res;
}

void build(int p,int l,int r){
	t[p].l = l, t[p].r = r;
	if(l==r){
		if(l==1) t[p].al = t[p].ar = l;
		else t[p].bl = t[p].br = l;
	}
	else{
		int m = (l+r)/2;
		build(2*p,l,m);
		build(2*p+1,m+1,r);
		t[p] = merge(t[2*p],t[2*p+1]);
	}
}

void change(int p,int x){
	if(t[p].l==t[p].r){
		t[p].bl = t[p].br = -1;
		t[p].al = t[p].ar = t[p].l;
	}
	else{
		int m = (t[p].l+t[p].r)/2;
		if(x<=m) change(2*p,x);
		else change(2*p+1,x);
		t[p] = merge(t[2*p],t[2*p+1]);
	}
}

int main(){
	int n;
	scanf("%d%lld",&n,&D);
	for(int i = 1; i <= n; i++) scanf("%lld",&a[i]);
	build(1,1,n);
	vis[1] = 1;
	long long ans = 0;
	for(int i = 1; i <= n-1; i++){
		int l = t[1].bestL, r = t[1].bestR;
		long long add = getPair(l,r);
		//printf("l = %d, r = %d: %lld\n",l,r,add);
		ans += add;
		if(!vis[l])	change(1,l), vis[l] = 1;
		else change(1,r), vis[r] = 1;
	}
	printf("%lld\n",ans);
	return 0;
}
