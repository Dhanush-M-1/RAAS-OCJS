#include<stdio.h>
bool dp[366][3][3][8][8][8][8];
int dat[365][16];
int dame[365][3][3];
int main(){
	int a;
	while(scanf("%d",&a),a){
		for(int i=0;i<a;i++)
			for(int j=0;j<16;j++)
				scanf("%d",&dat[i][j]);
		for(int i=0;i<a;i++)
			for(int j=0;j<3;j++)
				for(int jj=0;jj<3;jj++)
				for(int k=0;k<7;k++)
					for(int l=0;l<7;l++)
						for(int m=0;m<7;m++)
							for(int n=0;n<7;n++)
								dp[i][j][jj][k][l][m][n]=false;
		for(int i=0;i<365;i++)
			for(int j=0;j<3;j++)
				for(int k=0;k<3;k++)
					dame[i][j][k]=0;
		for(int i=0;i<a;i++){
			for(int j=0;j<3;j++)
				for(int k=0;k<3;k++)
					for(int l=0;l<2;l++)
						for(int m=0;m<2;m++)
							if(dat[i][(j+l)*4+k+m])dame[i][j][k]=1;
		}
		if(dat[0][5]|dat[0][6]|dat[0][10]|dat[0][9]);
		else dp[0][1][1][1][1][1][1]=true;
		for(int i=0;i<a-1;i++){
			for(int r=0;r<3;r++){
				for(int c=0;c<3;c++){
					for(int k=0;k<7;k++){
						for(int l=0;l<7;l++){
							for(int m=0;m<7;m++){
								for(int n=0;n<7;n++){
									if(!dp[i][r][c][k][l][m][n])continue;
									//printf("%d %d %d %d %d %d %d\n",i,r,c,k,l,m,n);
									if(r&&!dame[i+1][r-1][c]){
										int R=r-1;
										if(R==0&&c==0&&l<6&&m<6&&n<6)dp[i+1][R][c][0][l+1][m+1][n+1]=true;
										else if(R==0&&c==2&&k<6&&m<6&&n<6)dp[i+1][R][c][k+1][0][m+1][n+1]=true;
										else if(k<6&&l<6&&m<6&&n<6)dp[i+1][R][c][k+1][l+1][m+1][n+1]=true;
									}
									if(c&&!dame[i+1][r][c-1]){
										int C=c-1;
										if(r==0&&C==0&&l<6&&m<6&&n<6)dp[i+1][r][C][0][l+1][m+1][n+1]=true;
										else if(r==2&&C==0&&k<6&&l<6&&n<6)dp[i+1][r][C][k+1][l+1][0][n+1]=true;
										else if(k<6&&l<6&&m<6&&n<6)dp[i+1][r][C][k+1][l+1][m+1][n+1]=true;
									}
									if(r-1>0&&!dame[i+1][r-2][c]){
										int R=r-2;
										if(R==0&&c==0&&l<6&&m<6&&n<6)dp[i+1][R][c][0][l+1][m+1][n+1]=true;
										else if(R==0&&c==2&&k<6&&m<6&&n<6)dp[i+1][R][c][k+1][0][m+1][n+1]=true;
										else if(k<6&&l<6&&m<6&&n<6)dp[i+1][R][c][k+1][l+1][m+1][n+1]=true;
									}
									if(c-1>0&&!dame[i+1][r][c-2]){
										int C=c-2;
										if(r==0&&C==0&&l<6&&m<6&&n<6)dp[i+1][r][C][0][l+1][m+1][n+1]=true;
										else if(r==2&&C==0&&k<6&&l<6&&n<6)dp[i+1][r][C][k+1][l+1][0][n+1]=true;
										else if(k<6&&l<6&&m<6&&n<6)dp[i+1][r][C][k+1][l+1][m+1][n+1]=true;
									}
									if(r<2&&!dame[i+1][r+1][c]){
										int R=r+1;
										if(R==2&&c==0&&k<6&&l<6&&n<6)dp[i+1][R][c][k+1][l+1][0][n+1]=true;
										else if(R==2&&c==2&&k<6&&l<6&&m<6)dp[i+1][R][c][k+1][l+1][m+1][0]=true;
										else if(k<6&&l<6&&m<6&&n<6)dp[i+1][R][c][k+1][l+1][m+1][n+1]=true;
									}
									if(c<2&&!dame[i+1][r][c+1]){
										int C=c+1;
										if(r==0&&C==2&&k<6&&m<6&&n<6)dp[i+1][r][C][k+1][0][m+1][n+1]=true;
										else if(r==2&&C==2&&k<6&&l<6&&m<6)dp[i+1][r][C][k+1][l+1][m+1][0]=true;
										else if(k<6&&l<6&&m<6&&n<6)dp[i+1][r][C][k+1][l+1][m+1][n+1]=true;
									}
									if(r<1&&!dame[i+1][r+2][c]){
										int R=r+2;
										if(R==2&&c==0&&k<6&&l<6&&n<6)dp[i+1][R][c][k+1][l+1][0][n+1]=true;
										else if(R==2&&c==2&&k<6&&l<6&&m<6)dp[i+1][R][c][k+1][l+1][m+1][0]=true;
										else if(k<6&&l<6&&m<6&&n<6)dp[i+1][R][c][k+1][l+1][m+1][n+1]=true;
									}
									if(c<1&&!dame[i+1][r][c+2]){
										int C=c+2;
										if(r==0&&C==2&&k<6&&m<6&&n<6)dp[i+1][r][C][k+1][0][m+1][n+1]=true;
										else if(r==2&&C==2&&k<6&&l<6&&m<6)dp[i+1][r][C][k+1][l+1][m+1][0]=true;
										else if(k<6&&l<6&&m<6&&n<6)dp[i+1][r][C][k+1][l+1][m+1][n+1]=true;
									}
									if(!dame[i+1][r][c]){
										if(r==0&&c==0&&l<6&&m<6&&n<6)dp[i+1][r][c][0][l+1][m+1][n+1]=true;
										else if(r==0&&c==2&&k<6&&m<6&&n<6)dp[i+1][r][c][k+1][0][m+1][n+1]=true;
										else if(r==2&&c==0&&k<6&&l<6&&n<6)dp[i+1][r][c][k+1][l+1][0][n+1]=true;
										else if(r==2&&c==2&&k<6&&l<6&&m<6)dp[i+1][r][c][k+1][l+1][m+1][0]=true;
										else if(k<6&&l<6&&m<6&&n<6)dp[i+1][r][c][k+1][l+1][m+1][n+1]=true;
									}
								}
							}
						}
					}
				}
			}
		}
		bool ret=false;
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				for(int k=0;k<7;k++)
					for(int l=0;l<7;l++)
						for(int m=0;m<7;m++)
							for(int n=0;n<7;n++)
								if(dp[a-1][i][j][k][l][m][n])ret=true;
		if(ret)printf("1\n");
		else printf("0\n");
	}
}