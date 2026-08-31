#include<bits/stdc++.h>
typedef long long LL;
#define opt operator
#define pb push_back
#define pii std::pair<LL,LL>
const LL maxn=3e4+9,maxc=5;
LL Read(){
	LL x(0),f(1); char c=getchar();
	while(c<'0' || c>'9'){
		if(c=='-') f=-1; c=getchar();
	}
	while(c>='0' && c<='9'){
		x=(x<<3ll)+(x<<1ll)+c-'0'; c=getchar();
	}return x*f;
}
LL T,n,C,q;
LL p[maxn],dl[maxn],dr[maxn],sumw[maxc][(maxn*maxc<<1)+10];
pii range[maxc][maxn];
struct node{
	LL l,r,w;
	bool opt < (const node A)const{
		return p[r]<p[A.r];
	}
};
node L[maxc][(maxn*maxc<<1)+10];
LL Comb(LL N,LL M){
	if(N==M) return 1;
	if(N<M) return 0;
	LL ret(1);
	for(LL i=1;i<=M;++i) ret*=(N-i+1);
	for(LL i=1;i<=M;++i) ret/=i;
	//printf("%lld,%lld:%lld\n",N,M,ret);
	return ret;
}
LL Way(LL len,LL c){
	//printf("(%lld,%)")
	LL ret(1);
	for(LL i=1;i<=c;++i) ret+=Comb(len-1,i);
	return ret;
}
node F(LL i,LL c,LL w){
	LL l(range[c][i].first),r(range[c][i].second),nw(l-1);
	//printf("(%lld,%lld):(%lld,%lld)\n",c,i,l-dl[c]+1,r-dl[c]+1);
	LL v(sumw[c][range[c][i].first-1]);
	while(l<=r){
		LL mid(l+r>>1);
		if(sumw[c][mid]-v<w){
			nw=mid; l=mid+1;
		}else r=mid-1;
	}
	node tmp(L[c][nw+1]); tmp.w=sumw[c][nw]-v;
	return tmp;
}
void Init(){
	for(LL c=0;c<=C;++c){
		dl[c]=maxn*maxc+5; dr[c]=maxn*maxc+4;
		L[c][++dr[c]]=(node){n,n,1};
		range[c][n]=pii(dl[c],dr[c]);
		for(LL i=n-1;i>=1;--i){
			LL _l(0),_r(0);
			for(LL len=1;len<=std::min(c,n-i);++len){
				LL j(i+len);
				if(p[j]<p[i]){
					++_l;
					L[c][dl[c]-_l]=(node){i,j,Way(n-j,c-len)};
				}else{
					++_r;
					L[c][dr[c]+_r]=(node){i,j,Way(n-j,c-len)};
				}
			}
			if(_l){
                std::sort(L[c]+dl[c]-_l,L[c]+dl[c]);
				dl[c]-=_l;
			}
			if(_r){
				std::sort(L[c]+dr[c]+1,L[c]+dr[c]+_r+1);
				dr[c]+=_r;
			}
			range[c][i]=pii(dl[c],dr[c]);
		}
		sumw[c][dl[c]-1]=0;
		for(LL i=dl[c];i<=dr[c];++i){
			sumw[c][i]=sumw[c][i-1]+L[c][i].w;
		}
		/*
		for(LL i=dl[c];i<=dr[c];++i){
			printf("(%lld,%lld,%lld)",L[c][i].l,L[c][i].r,L[c][i].w);
		}
		puts("");
		*/
	}
}
int main(){
	T=Read();
	while(T--){
		n=Read(); C=Read(); q=Read();
		for(LL i=1;i<=n;++i) p[i]=Read();
		Init();
		//puts("033");
		while(q--){
            LL pos1(Read()),pos2(Read());
			if(pos2>sumw[C][dr[C]]){
				puts("-1"); continue;
			}
			LL pos(1);
			LL c(C);
			std::vector<node> suq;
			while(true){
				node tmp(F(pos,c,pos2));
				suq.pb(tmp);
				//printf("(%lld,%lld:%lld)\n",tmp.l,tmp.r,tmp.w);
				//if(!tmp.l) exit(0);
				pos2-=tmp.w;
				c-=tmp.r-tmp.l;
				pos=tmp.r+1;
				if(pos>n || !pos2) break;
			}
			LL flag(0);
            for(LL i=0;i<suq.size();++i){
				LL l(suq[i].l),r(suq[i].r);
				if(l<=pos1 && pos1<=r){
					printf("%lld\n",p[r-(pos1-l)]);
					flag=1;
					break;
				}
			}
			if(!flag){
				printf("%lld\n",p[pos1]);
			}
		}
	}
}