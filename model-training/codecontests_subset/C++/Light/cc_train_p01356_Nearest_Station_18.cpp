#include<cstdio>
#include<algorithm>

using namespace std;

long long vals[50];
long long N;
long long M;

long long dfs(int id,int toTake,int taken,long long curVal,bool flg){
//	printf("%d %d %d %lld\n",id,toTake,taken,curVal);
	if(id==-1){
		if(taken==toTake) return curVal;
		else return -1;
	}
	if(toTake==taken){
		return curVal;
	}
	long long nxtVal=curVal+vals[id];
//	printf("nxt=%lld\n",nxtVal);
	long long res=-1;
	if(nxtVal>M){
		res=dfs(id-1,toTake,taken,curVal,flg);
		return res;
	}
	if(flg==false){
		//not take
		res=dfs(id-1,toTake,taken,curVal,true);
	}
	long long res2=dfs(id-1,toTake,taken+1,nxtVal,flg);
	res=max(res,res2);
	return res;
}

long long dfs2(int id,int toTake,int taken,long long curVal){
	if(id==-1){
		if(toTake!=taken) return -1;
		if(curVal<M) return -1;
		return curVal;
	}
	long long nxtVal=curVal+vals[id];
	if(toTake==taken+id+1){
		long long tmp=dfs2(id-1,toTake,taken+1,nxtVal);
		return tmp;
	}
	long long notTake=curVal;
	for(int i=1;i<=toTake-taken;i++){
		notTake+=vals[id-i];
	}
	long long res;
	if(notTake>=M){
		res=dfs2(id-1,toTake,taken,curVal);
	}else{
		res=dfs2(id-1,toTake,taken+1,nxtVal);
	}
	return res;
}

long long mult(long long a,long long b,long long c){
	long long x=c/a;
	if(b>x) return -1;
	long long res=a*b;
	if(res>c) return -1;
	return res;
}

int main(){
	long long a,b,p,q;
	scanf("%lld%lld%lld%lld%lld%lld",&N,&M,&a,&b,&p,&q);
	if(a==1&&b==1){
		long long x=p+q;
		long long num=M/x;
		num=min(num,N);
		long long train=x*num;
		long long ans=M-train;
		if(num+1<=N){
			train+=x;
			ans=min(ans,train-M);
		}
		printf("%lld\n",ans);
		return 0;
	}
	long long pa=1,pb=1;
	int n=0;
	for(int i=0;i<N;i++){
		long long cur1=mult(pa,p,M*2);
		long long cur2=mult(pb,q,M*2);
		if(cur1==-1||cur2==-1) break;
		long long cur=cur1+cur2;
		if(cur>M*2) break;
		vals[n++]=cur;
		pa=mult(pa,a,M*2);
		pb=mult(pb,b,M*2);
		if(pa==-1||pb==-1) break;
	}
	if(n==0){
		printf("%lld\n",M);
		return 0;
	}
//	for(int i=0;i<n;i++){
//		printf("%d %lld\n",i,vals[i]);
//	}
	N=n;
	long long ans=M;
	for(int i=1;i<=n;i++){
		long long tmp=dfs(n-1,i,0,0,false);
//		printf("%d %lld\n",i,tmp);
		if(tmp==-1) continue;
		ans=min(ans,M-tmp);
	}
	for(int i=1;i<=n;i++){
		long long tmp=dfs2(n-1,i,0,0);
		if(tmp==-1) continue;
		ans=min(ans,tmp-M);
	}
	printf("%lld\n",ans);
	return 0;
}