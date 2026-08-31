#include <iostream>
#include <fstream>
#include <stdio.h>
#include <math.h>
#include <time.h>
#include <string>
#include <tuple>
#include <vector>
#include <map>
#include <unordered_map>
#include <list>
#include <set>
#include <stack>
#include <queue>
#include <cstdlib>
#include <algorithm>
#include <random>
#include <cassert>
using namespace std;
#define LL long long
#define MP(a, b) make_pair(a, b)
#undef INT_MIN
#undef INT_MAX
#define INT_MIN -2147483647
#define INT_MAX 2147483647
#define LL_MIN (LL)-3223372036854775807
#define LL_MAX (LL)9223372036854775807
#define PI 3.14159265359

#define MOD 10000

string A,B;
int M;

int dp[501][10][3][500][4];
//order501*10*2*500*4*10=10^8
int solve(int now, int mae, int updown, int amari, int giri){
	if(now == B.size() && amari == 0) return 1;
	if(dp[now][mae][updown][amari][giri] != -1) return dp[now][mae][updown][amari][giri];
	int re = 0;
	if(giri == 0){
		if(updown == 0){
			for(int i=mae+1; i<=9; i++) re += solve(now+1,i,1,(amari*10+i)%M, 0);
		}
		if(updown == 1){
			for(int i=mae-1; i>=0; i--) re += solve(now+1,i,0,(amari*10+i)%M, 0);
		}
		if(updown == 2){
			for(int i=1; i<=9; i++) re += solve(now+1,i,0,(amari*10+i)%M, 0) + solve(now+1,i,1,(amari*10+i)%M, 0);
		}
	}
	if(giri == 1){
		if(updown == 0){
			for(int i=mae+1; i<=9; i++){
				if(A[A.size()-B.size()+now]-'0' == i) re += solve(now+1,i,1,(amari*10+i)%M, 1);
				if(A[A.size()-B.size()+now]-'0' < i) re += solve(now+1,i,1,(amari*10+i)%M, 0);
			}
		}
		if(updown == 1){
			for(int i=mae-1; i>=0; i--){
				if(A[A.size()-B.size()+now]-'0' == i) re += solve(now+1,i,0,(amari*10+i)%M, 1);
				if(A[A.size()-B.size()+now]-'0' < i) re += solve(now+1,i,0,(amari*10+i)%M, 0);
			}
		}
		if(updown == 2){
			for(int i=1; i<=9; i++){
				if(A[A.size()-B.size()+now]-'0' == i) re += solve(now+1,i,0,(amari*10+i)%M, 1) + solve(now+1,i,1,(amari*10+i)%M, 1);
				if(A[A.size()-B.size()+now]-'0' < i) re += solve(now+1,i,0,(amari*10+i)%M, 0) + solve(now+1,i,1,(amari*10+i)%M, 0);
			}
		}
	}
	if(giri == 2){
		if(updown == 0){
			for(int i=mae+1; i<=9; i++){
				if(B[now]-'0' == i) re += solve(now+1,i,1,(amari*10+i)%M, 2);
				if(B[now]-'0' > i) re += solve(now+1,i,1,(amari*10+i)%M, 0);
			}
		}
		if(updown == 1){
			for(int i=mae-1; i>=0; i--){
				if(B[now]-'0' == i) re += solve(now+1,i,0,(amari*10+i)%M, 2);
				if(B[now]-'0' > i) re += solve(now+1,i,0,(amari*10+i)%M, 0);
			}
		}
		if(updown == 2){
			for(int i=1; i<=9; i++){
				if(B[now]-'0' == i) re += solve(now+1,i,0,(amari*10+i)%M, 2) + solve(now+1,i,1,(amari*10+i)%M, 2);
				if(B[now]-'0' > i) re += solve(now+1,i,0,(amari*10+i)%M, 0) + solve(now+1,i,1,(amari*10+i)%M, 0);
			}
		}
	}
	if(giri == 3){
		if(updown == 0){
			for(int i=mae+1; i<=9; i++){
				if(A[now]-'0' == i && B[now]-'0' == i) re += solve(now+1,i,1,(amari*10+i)%M, 3);
				else if(A[now]-'0' == i && B[now]-'0' > i) re += solve(now+1,i,1,(amari*10+i)%M, 1);
				else if(B[now]-'0' == i && A[now]-'0' < i) re += solve(now+1,i,1,(amari*10+i)%M, 2);
				else if(A[now]-'0' < i & i < B[now]-'0') re += solve(now+1,i,1,(amari*10+i)%M, 0);
			}
		}
		if(updown == 1){
			for(int i=mae-1; i>=0; i--){
				if(A[now]-'0' == i && B[now]-'0' == i) re += solve(now+1,i,0,(amari*10+i)%M, 3);
				else if(A[now]-'0' == i && B[now]-'0' > i) re += solve(now+1,i,0,(amari*10+i)%M, 1);
				else if(B[now]-'0' == i && A[now]-'0' < i) re += solve(now+1,i,0,(amari*10+i)%M, 2);
				else if(A[now]-'0' < i & i < B[now]-'0') re += solve(now+1,i,0,(amari*10+i)%M, 0);
			}
		}
		if(updown == 2){
			for(int i=1; i<=9; i++){
				if(A[now]-'0' == i && B[now]-'0' == i) re += solve(now+1,i,0,(amari*10+i)%M, 3) + solve(now+1,i,1,(amari*10+i)%M, 3);
				else if(A[now]-'0' == i && B[now]-'0' > i) re += solve(now+1,i,0,(amari*10+i)%M, 1) + solve(now+1,i,1,(amari*10+i)%M, 1);
				else if(B[now]-'0' == i && A[now]-'0' < i) re += solve(now+1,i,0,(amari*10+i)%M, 2) + solve(now+1,i,1,(amari*10+i)%M, 2);
				else if(A[now]-'0' < i & i < B[now]-'0') re += solve(now+1,i,0,(amari*10+i)%M, 0) + solve(now+1,i,1,(amari*10+i)%M, 0);
			}
		}
	}
	//cout << now << " " << mae << " " << updown << " " << amari << " " << giri << " " << re << endl;
	return dp[now][mae][updown][amari][giri] = re % MOD;
}

int main() {
	iostream::sync_with_stdio(false);

	cin >> A >> B >> M;

	for(int i=0; i<B.size(); i++){
		for(int j=0; j<10; j++){
			for(int k=0; k<3; k++){
				for(int l=0; l<M; l++){
					for(int m=0; m<4; m++){
						dp[i][j][k][l][m] = -1;
					}
				}
			}
		}
	}

	int ans = 0;
	if(A.size() == B.size()){
		/*if(A[0]==B[0]) ans = solve(1, A[0]-'0', 0, 0, 3);
		else{
			ans += solve(1, A[0]-'0', 0, 0, 1);
			for(int i=A[0]-'0'+1; i<B[0]-'0'; i++){
				ans += solve(1, i, 0, 0, 0);
			}
			ans += solve(0, B[0]-'0', 0, 0, 2);
		}*/

		ans = solve(0, 0, 2, 0, 3);
		if(A.size() == 1) ans /= 2;
	}
	else{
		/*ans += solve(0, B[0]-'0', 0, 0, 2);
		for(int i=B[0]-'0'-1; i>=1; i--){
			ans += solve(0, i, 0, 0, 0);
		}
		for(int i=1; i<B.size()-A.size(); i++){

		}*/
		ans += solve(0, 0, 2, 0, 2);
		for(int i=1; i<B.size()-A.size(); i++){
			ans += solve(i, 0, 2, 0, 0);
		}
		int tmp = solve(B.size()-A.size(), 0, 2, 0, 1);
		if(A.size() == 1) tmp /= 2; //up,downでダブっているため
		ans += tmp;
	}
	cout << ans % MOD << endl;
	

	return 0;
}

