#include<bits/stdc++.h>
#define ci const int&
#define TOT(tc,ql,qr) ((qr>=0?s[qr][tc]:0)-(ql>0?s[ql-1][tc]:0))
using namespace std;
struct elem{
	int l,r;
	long long num;
};
int T,n,C,Q,p[30010],li[30010][5],ri[30010][5],l,r,mid,qi,nc,ni,opl[5],opr[5],sz;
long long qj,s[120010][5];
vector<elem>L[5],tl[30010][5],tr[30010][5];
bool cmp(elem x,elem y){
	return p[x.r]<p[y.r];
}
long long NUM(ci x,ci op){
	if(op==0)return 1;
	if(x<op)return 0;
	if(op==1)return x;
	if(op==2)return x*(x-1)>>1;
	if(op==3)return 1ll*x*(x-1)*(x-2)/6;
	return 1ll*x*(x-1)*(x-2)*(x-3)/24;
}
long long Calc(ci x,ci op){
	long long ret=0;
	for(int i=0;i<=op;++i)ret+=NUM(x-1,i);
	return ret;
}
int main(){
	scanf("%d",&T);
	while(T--){
		scanf("%d%d%d",&n,&C,&Q);
		for(int i=1;i<=4;++i)vector<elem>().swap(L[i]),ri[n+1][i]=0;
		for(int i=1;i<=n;++i){
			scanf("%d",&p[i]);
			for(int j=1;j<=C;++j)vector<elem>().swap(tl[i][j]),vector<elem>().swap(tr[i][j]);
		}
		for(int c=1;c<=C;++c){
			tl[n][c].push_back((elem){n+1,n+1,1});
			for(int i=n-1;i>=1;--i){
				for(int j=i+1;j<=i+c&&j<=n;++j)p[j]<p[i]?tl[i][c].push_back((elem){i,j,Calc(n-j,c-(j-i))}):tr[i][c].push_back((elem){i,j,Calc(n-j,c-(j-i))});
				if(tl[i][c].size())sort(tl[i][c].begin(),tl[i][c].end(),cmp);
				if(tr[i][c].size())sort(tr[i][c].begin(),tr[i][c].end(),cmp);
				li[i+1][c]=tl[i][c].size(),ri[i+1][c]=li[i+1][c]+ri[i+2][c]+tr[i+1][c].size();
			}
			li[1][c]=0,ri[1][c]=ri[2][c]+tr[1][c].size();
			for(int i=2;i<=n;++i)li[i][c]+=li[i-1][c],ri[i][c]+=li[i-1][c];
			for(int i=1;i<=n;++i)for(int j=0;j<tl[i][c].size();++j)L[c].push_back(tl[i][c][j]);
			for(int i=n;i>=1;--i)for(int j=0;j<tr[i][c].size();++j)L[c].push_back(tr[i][c][j]);
			s[0][c]=L[c][0].num;
			for(int i=1;i<L[c].size();++i)s[i][c]=s[i-1][c]+L[c][i].num;
		}
		while(Q--){
			scanf("%d%lld",&qi,&qj),nc=C,sz=0,ni=1;
			if(qj>Calc(n,C)){
				puts("-1");
				goto Skip;
			}
			while(nc&&ni<=n){
				l=li[ni][nc],r=ri[ni][nc];
				while(l<r)mid=l+r>>1,TOT(nc,li[ni][nc],mid)>=qj?r=mid:l=mid+1;
				++sz,qj-=TOT(nc,li[ni][nc],l-1),opl[sz]=L[nc][l].l,opr[sz]=L[nc][l].r,ni=opr[sz]+1,nc-=L[nc][l].r-L[nc][l].l;
			}
			for(int i=1;i<=sz;++i)if(opl[i]<=qi&&qi<=opr[i]){
				printf("%d\n",p[opl[i]+opr[i]-qi]);
				goto Skip;
			}
			printf("%d\n",p[qi]);
			Skip:;
		}
	}
	return 0;
}