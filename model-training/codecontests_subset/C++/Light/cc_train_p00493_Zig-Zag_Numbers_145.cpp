#include<cstdio>
#include<cstring>

#define rep(i,n) for(int i=0;i<(n);i++)

using namespace std;

int n,m;
char s[512];

int dp[512][500][10][2];
// 今何桁目か, i 桁目を自由に決められるか, i 桁目までの mod m での値, i-1 桁目の数字, 一つ前で上がったか下がったか, 直前まですべて 0 だったか
int dfs(int i,bool b,int mod,int pre,bool up,bool z){
	if(i==n) return mod==0?1:0;

	if(b && !z && dp[i][mod][pre][up?1:0]!=-1) return dp[i][mod][pre][up?1:0];

	int res=0;
	int d0=s[i]-'0';
	if(z){
		res+=dfs(i+1,true,(10*mod+0)%m,0,true,true);
		if(!b){
			for(int d=1;d<=d0;d++){
				res+=dfs(i+1,d<d0,(10*mod+d)%m,d, true,false);
				res+=dfs(i+1,d<d0,(10*mod+d)%m,d,false,false);
			}
		}
		else{
			for(int d=1;d<10;d++){
				res+=dfs(i+1,true,(10*mod+d)%m,d, true,false);
				res+=dfs(i+1,true,(10*mod+d)%m,d,false,false);
			}
		}
	}
	else{
		if(!b){
			if(up){ // 前回上がったなら今回下がる
				for(int d=0;d<=d0&&d<pre;d++){
					res+=dfs(i+1,d<d0,(10*mod+d)%m,d,!up,false);
				}
			}
			else{ // 前回下がったなら今回上がる
				for(int d=pre+1;d<=d0;d++){
					res+=dfs(i+1,d<d0,(10*mod+d)%m,d,!up,false);
				}
			}
		}
		else{
			if(up){
				rep(d,pre){
					res+=dfs(i+1,true,(10*mod+d)%m,d,!up,false);
				}
			}
			else{
				for(int d=pre+1;d<10;d++){
					res+=dfs(i+1,true,(10*mod+d)%m,d,!up,false);
				}
			}
		}
	}

	res%=10000;
	if(b && !z) dp[i][mod][pre][up?1:0]=res;

	return res;
}

int solve(const char *a){
	strcpy(s,a);
	n=strlen(s);
	memset(dp,-1,sizeof dp);
	int res=dfs(0,false,0,0,true,true);
	// dfs で 1, 2, ..., 9 を二回カウントしてしまうので、その分を答えから引く
	for(int i=1;i<10;i++){
		if((n>=2 || i<=a[0]-'0') && i%m==0) res--;
	}
	return (res+10000)%10000;
}

// decrement
char *dec(char *a){
	int n=strlen(a),i;
	for(i=n-1;a[i]=='0';i--) a[i]='9';
	a[i]--;
	if(n>=2 && a[0]=='0') memmove(a,a+1,n); // leading 0 を削除
	return a;
}

int main(){
	char a[512],b[512];
	scanf("%s%s%d",a,b,&m);
	printf("%d\n",(solve(b)-solve(dec(a))+10000)%10000);
	return 0;
}