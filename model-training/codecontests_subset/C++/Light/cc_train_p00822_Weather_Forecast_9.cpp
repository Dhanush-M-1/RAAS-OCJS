#include<set>
#include<cstdio>
#include<vector>

#define rep(i,n) for(int i=0;i<(n);i++)

using namespace std;

int to[9][5]; // to[i] : 雲が位置 i から移動できる位置

int n;
int sun[366][16]; // sun[t][j]==1 <=> t 日目にマス j は晴れていないといけない
int rain[9][16]; // rain[i][j]==1 <=> 雲が位置 i にいるとき, マス j は雨

set< vector<char> > vis[366][9];
bool dfs(int t,int i,vector<char> last){
	if(t%2==0){ // MLE したので半分だけメモ化
		if(vis[t][i].count(last)==1) return false;
		vis[t][i].insert(last);
	}

	rep(j,16){
		if(rain[i][j]==1){
			last[j]=0;
			if(sun[t][j]==1) return false;
		}
		else{
			last[j]++;
			if(last[j]>=7) return false;
		}
	}

	if(t==n) return true;

	rep(j,5) if(dfs(t+1,to[i][j],last)) return true;
	return false;
}

int main(){
	to[0][0]=0;
	to[0][1]=1;
	to[0][2]=2;
	to[0][3]=3;
	to[0][4]=6;
	to[1][0]=1;
	to[1][1]=0;
	to[1][2]=2;
	to[1][3]=4;
	to[1][4]=7;
	to[2][0]=2;
	to[2][1]=0;
	to[2][2]=1;
	to[2][3]=5;
	to[2][4]=8;
	to[3][0]=3;
	to[3][1]=0;
	to[3][2]=4;
	to[3][3]=5;
	to[3][4]=6;
	to[4][0]=4;
	to[4][1]=1;
	to[4][2]=3;
	to[4][3]=5;
	to[4][4]=7;
	to[5][0]=5;
	to[5][1]=2;
	to[5][2]=3;
	to[5][3]=4;
	to[5][4]=8;
	to[6][0]=6;
	to[6][1]=0;
	to[6][2]=3;
	to[6][3]=7;
	to[6][4]=8;
	to[7][0]=7;
	to[7][1]=1;
	to[7][2]=4;
	to[7][3]=6;
	to[7][4]=8;
	to[8][0]=8;
	to[8][1]=2;
	to[8][2]=5;
	to[8][3]=6;
	to[8][4]=7;
	rain[0][ 0]=rain[0][ 1]=rain[0][ 4]=rain[0][ 5]=1;
	rain[1][ 1]=rain[1][ 2]=rain[1][ 5]=rain[1][ 6]=1;
	rain[2][ 2]=rain[2][ 3]=rain[2][ 6]=rain[2][ 7]=1;
	rain[3][ 4]=rain[3][ 5]=rain[3][ 8]=rain[3][ 9]=1;
	rain[4][ 5]=rain[4][ 6]=rain[4][ 9]=rain[4][10]=1;
	rain[5][ 6]=rain[5][ 7]=rain[5][10]=rain[5][11]=1;
	rain[6][ 8]=rain[6][ 9]=rain[6][12]=rain[6][13]=1;
	rain[7][ 9]=rain[7][10]=rain[7][13]=rain[7][14]=1;
	rain[8][10]=rain[8][11]=rain[8][14]=rain[8][15]=1;

	while(scanf("%d",&n),n){
		rep(t,n) rep(j,16) scanf("%d",sun[t]+j);
		rep(t,n+1) rep(i,9) vis[t][i].clear();

		vector<char> last(16); // 最後に雨が降ったのは何日前か ( int だと MLE した )
		puts(dfs(0,4,last)?"1":"0");
	}

	return 0;
}