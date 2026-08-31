#include<bits/stdc++.h>
typedef long long int ll;
typedef unsigned long long int ull;
#define BIG_NUM 2000000000
#define MOD 1000000007
#define EPS 0.000000001
using namespace std;


int main(){

	int POW[22];
	for(int i = 0; i < 22; i++)POW[i] = pow(2,i);

	ll N,M,A,B,P,Q;

	scanf("%lld %lld %lld %lld %lld %lld",&N,&M,&A,&B,&P,&Q);

	if(A == 1 && B == 1){

		ll num = M/(P+Q);

		if(num >= N){
			printf("%lld\n",M-N*(P+Q));
		}else{
			printf("%lld\n",min(M%(P+Q),(num+1)*(P+Q)-M)); //少し足りないと、少し多いの、差が小さい方
		}

		return 0;
	}

	vector<ll> FIRST;

	ll tmp = P+Q;
	ll a = 1, b = 1;
	ll count = 0,over_count = 0;

	double check;

	while(true){

		if(tmp > M)over_count++; //超過は1回だけ許す

		FIRST.push_back(tmp);
		count++;
		if(count == N || over_count == 1)break;

		check = P*a*A+Q*b*B;
		if(check > (double)M)break;

		a *= A;
		b *= B;

		tmp = P*a+Q*b;
	}

	//printf("count:%lld\n",count);

	//数字を2つのグループに振り分ける
	vector<ll> G[2];
	for(ll i = 0; i < FIRST.size(); i++){
		if(i <= (FIRST.size())/2){
			G[0].push_back(FIRST[i]);
		}else{
			G[1].push_back(FIRST[i]);
		}
	}

	int num[2];
	num[0] = (int)G[0].size();
	num[1] = (int)G[1].size();

	//printf("num_0:%d\n",num[0]);

	//各グループで数字を作る
	vector<ll> V[2];
	V[1].push_back(0);
	for(int group = 0; group < 2; group++){
		for(int state = 0; state < POW[num[group]]; state++){
			tmp = 0;
			for(int loop = 0; loop < num[group]; loop++){
				if(state & (1 << loop)){
					tmp += G[group][loop];
				}
			}
			V[group].push_back(tmp);
		}
		sort(V[group].begin(),V[group].end());
		V[group].erase(unique(V[group].begin(),V[group].end()),V[group].end());
	}

	ll ans = M,tmp_ans;

	int left,right,m,loc;

	for(int i = 0; i < V[0].size(); i++){

		if(V[0][i] >= M){
			ans = min(ans,V[0][i]-M);
			break;
		}

		//2分探索で、和がMを超えない、最大のindexを求める
		left = 0,right = (int)V[1].size()-1,m = (left+right);
		loc = 0;

		while(left <= right){
			if(V[0][i]+V[1][m] <= M){
				loc = m;
				left = m+1;
			}else{
				right = m-1;
			}
			m = (left+right)/2;
		}

		tmp_ans = (M-(V[0][i]+V[1][loc]));
		if(loc < (int)V[1].size()-1){
			tmp_ans = min(tmp_ans,V[0][i]+V[1][loc+1]-M);
		}
		//printf("i:%d tmp_ans:%lld\n",i,tmp_ans);
		ans = min(ans,tmp_ans);
	}

	printf("%lld\n",ans);

	return 0;
}

