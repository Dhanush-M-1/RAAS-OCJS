#include<iostream>
#include<cstdio>
#include<cstring>
#include<string>

using namespace std;
string str[2];
const short mod=10000;
int dmod;
//何桁目か・mod・a桁目の数字・↑(0)、↓(1)、一桁目(2)・Bと一致しているか(1)否か(0)
unsigned short dp[501][501][11][3][3];
//何桁目か・mod・a桁目の数字・↑(0)、↓(1)、一桁目(2)・Aと一致しているか(1)否か(0)

void dfs(int a,int div,int c,int d,int e){
	
}

int main(void){
	memset(dp,0,sizeof(dp));
	cin >> str[0];
	cin >> str[1];
	cin >> dmod;

	//1~Bまでのジグザグ数の計算
	//一桁目だけ計算
	for(int i=0;i<=(str[1][0]-'0');i++){
		int b=i%dmod;
		if(i==0)continue;
		else if(i!=(str[1][0]-'0'))dp[0][b][i][2][0]=1;
		else dp[0][b][i][2][1]=1;
	}
	for(int a=1;a<str[1].size();a++){
		//0が続く場合
	//	dp[a][0][0][2][2]=1;
		//ここから登場する数
		for(int c=1;c<=9;c++){
			dp[a][c%dmod][c][2][0]=1;
		}
		for(int b=0;b<dmod;b++){
			for(int c=0;c<=9;c++){
				for(int pc=0;pc<=9;pc++){
					int div=(b*10+c)%dmod;
					if(c>pc){
						dp[a][div][c][0][0]=(dp[a][div][c][0][0]+dp[a-1][b][pc][1][0]+dp[a-1][b][pc][2][0])%mod;
						if(pc==0)dp[a][div][c][0][0]=(dp[a][div][c][0][0]+dp[a][b][pc][2][2])%mod;
						if(c<(str[1][a]-'0')){
							dp[a][div][c][0][0]=(dp[a][div][c][0][0]+dp[a-1][b][pc][1][1]+dp[a-1][b][pc][2][1])%mod;
						}
						if(c==(str[1][a]-'0')){
							dp[a][div][c][0][1]=(dp[a][div][c][0][1]+dp[a-1][b][pc][1][1]+dp[a-1][b][pc][2][1])%mod;
						}
					}
					if(c<pc){
						dp[a][div][c][1][0]=(dp[a][div][c][1][0]+dp[a-1][b][pc][0][0]+dp[a-1][b][pc][2][0])%mod;
						if(c<(str[1][a]-'0')){
							dp[a][div][c][1][0]=(dp[a][div][c][1][0]+dp[a-1][b][pc][0][1]+dp[a-1][b][pc][2][1])%mod;
						}
						if(c==(str[1][a]-'0')){
							dp[a][div][c][1][1]=(dp[a][div][c][1][1]+dp[a-1][b][pc][0][1]+dp[a-1][b][pc][2][1])%mod;
						}
					}
				}
			}
		}
	}
	//

	int ans=0;
	//1~Bまでの分を足す
	for(int i=0;i<10;i++){
		ans=(ans+dp[str[1].size()-1][0][i][0][0]+dp[str[1].size()-1][0][i][0][1]+dp[str[1].size()-1][0][i][1][0]+dp[str[1].size()-1][0][i][1][1]+dp[str[1].size()-1][0][i][2][0]+dp[str[1].size()-1][0][i][2][1])%mod;
	}

	memset(dp,0,sizeof(dp));

	//1~Aまでのジグザグ数の計算
	for(int i=0;i<=(str[0][0]-'0');i++){
		int b=i%dmod;
		if(i==0)continue;
		else if(i!=(str[0][0]-'0'))dp[0][b][i][2][0]=1;
		else dp[0][b][i][2][1]=1;
	}
	for(int a=1;a<str[0].size();a++){
		//0が続く場合
	//	dp[a][0][0][2][2]=1;
		//ここから登場する数
		for(int c=1;c<=9;c++){
			dp[a][c%dmod][c][2][0]=1;
		}
		for(int b=0;b<dmod;b++){
			for(int c=0;c<=9;c++){
				for(int pc=0;pc<=9;pc++){
					int div=(b*10+c)%dmod;
					if(c>pc){
						dp[a][div][c][0][0]=(dp[a][div][c][0][0]+dp[a-1][b][pc][1][0]+dp[a-1][b][pc][2][0])%mod;
						if(pc==0)dp[a][div][c][0][0]=(dp[a][div][c][0][0]+dp[a][b][pc][2][2])%mod;
						if(c<(str[0][a]-'0')){
							dp[a][div][c][0][0]=(dp[a][div][c][0][0]+dp[a-1][b][pc][1][1]+dp[a-1][b][pc][2][1])%mod;
						}
						if(c==(str[0][a]-'0')){
							dp[a][div][c][0][1]=(dp[a][div][c][0][1]+dp[a-1][b][pc][1][1]+dp[a-1][b][pc][2][1])%mod;
						}
					}
					if(c<pc){
						dp[a][div][c][1][0]=(dp[a][div][c][1][0]+dp[a-1][b][pc][0][0]+dp[a-1][b][pc][2][0])%mod;
						if(c<(str[0][a]-'0')){
							dp[a][div][c][1][0]=(dp[a][div][c][1][0]+dp[a-1][b][pc][0][1]+dp[a-1][b][pc][2][1])%mod;
						}
						if(c==(str[0][a]-'0')){
							dp[a][div][c][1][1]=(dp[a][div][c][1][1]+dp[a-1][b][pc][0][1]+dp[a-1][b][pc][2][1])%mod;
						}
					}
				}
			}
		}
	}
	//

	//1~A-1までの分を引く
	for(int i=0;i<10;i++){
		ans=(ans+mod*2-dp[str[0].size()-1][0][i][0][0]-dp[str[0].size()-1][0][i][1][0]-dp[str[0].size()-1][0][i][2][0])%mod;
	}
	cout << ans << endl;
    return 0;
}