#include<iostream>
#include<string>
#include<algorithm>
using namespace std;
typedef long long int ll;
static const int MAX_LEN = 501;
static const int MAX_M = 500;

string A, B;
int M;
int memo[MAX_LEN][10][MAX_M][3][2];

int solve(string S){
	if(S == "0") return 0;
	int sum[MAX_LEN];
	fill(sum, sum + S.length(), 0);
	for(int i = 0; i < S.length(); i++){
		if(i == 0){
			sum[i] = S[i] - '0';
		}else{
			sum[i] = (sum[i - 1] * 10 + (S[i] - '0'));
		}
		sum[i] %= M;
	}
	for(int i = 0; i < S.length(); i++){
		for(int j = 0; j < 10; j++){
			for(int k = 0; k < M; k++){
				for(int l = 0; l < 3; l++){
					for(int m = 0; m < 2; m++){
						memo[i][j][k][l][m] = 0;
					}
				}
			}
		}
	}
	for(int i = 1; i <= S[0] - '0'; i++){
		if(i == S[0] - '0'){
			memo[0][i][i % M][2][1]++;
		}else{
			memo[0][i][i % M][2][0]++;
		}
	}
	for(int i = 1; i < S.length(); i++){
		for(int j = 1; j < 10; j++){
			memo[i][j][j % M][2][0]++;
		}
		for(int j = 0; j < M; j++){
			for(int k = 0; k < 10; k++){
				for(int l = 0; l < 10; l++){
					if(l > k){
						memo[i][l][(j * 10 + l) % M][1][0] += memo[i - 1][k][j][0][0];
						memo[i][l][(j * 10 + l) % M][1][0] += memo[i - 1][k][j][2][0];
						memo[i][l][(j * 10 + l) % M][1][0] %= 10000;
					}else if(l < k){
						memo[i][l][(j * 10 + l) % M][0][0] += memo[i - 1][k][j][1][0];
						memo[i][l][(j * 10 + l) % M][0][0] += memo[i - 1][k][j][2][0];
						memo[i][l][(j * 10 + l) % M][0][0] %= 10000;
					}
				}
			}
		}
		for(int j = 0; j < S[i] - '0'; j++){
			if(j > (S[i - 1] - '0')){
				memo[i][j][(sum[i - 1] * 10 + j) % M][1][0] += (memo[i - 1][S[i - 1] - '0'][sum[i - 1]][0][1] + memo[i - 1][S[i - 1] - '0'][sum[i - 1]][2][1]);
			}else if(j < (S[i - 1] - '0')){
				memo[i][j][(sum[i - 1] * 10 + j) % M][0][0] += (memo[i - 1][S[i - 1] - '0'][sum[i - 1]][1][1] + memo[i - 1][S[i - 1] - '0'][sum[i - 1]][2][1]);
			}
		}
		if(S[i] > S[i - 1]){
			memo[i][S[i] - '0'][sum[i]][1][1] = (memo[i - 1][S[i - 1] - '0'][sum[i - 1]][0][1] + memo[i - 1][S[i - 1] - '0'][sum[i - 1]][2][1]);
		}else if(S[i] < S[i - 1]){
			memo[i][S[i] - '0'][sum[i]][0][1] = (memo[i - 1][S[i - 1] - '0'][sum[i - 1]][1][1] + memo[i - 1][S[i - 1] - '0'][sum[i - 1]][2][1]);
		}
	}
	int res = 0;
	for(int i = 0; i < 3; i++){
		for(int j = 0; j < 10; j++){
			res += memo[S.length() - 1][j][0][i][0];
		}
		res += memo[S.length() - 1][S[S.length() - 1] - '0'][0][i][1];
	}
	return res % 10000;
	
}
int main(){
	cin >> A >> B >> M;
	reverse(A.begin(), A.end());
	for(int i = 0; i < A.length(); i++){
		if(A[i] != '0'){
			A[i]--;
			break;
		}else A[i] = '9';
	}
	if(A[A.length() - 1] == '0' && A != "0") A.erase(A.begin() + A.length() - 1);
	reverse(A.begin(), A.end());
	cout << (solve(B) - solve(A) + 10000) % 10000 << endl;
	return 0;
}
