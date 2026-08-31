#include<iostream>
#include<string>
using namespace std;
string s;
int M,len;
int dp[2][3][10][500][500];
int getans(string str);
string change(string str);
int bfs(bool flg,int pm,int num,int mod,int idx);
int main(){
	string a,b;
	cin >> a; cin >> b; cin >> M;
	//cout << getans(b) << endl;
	//cout << getans(change(a)) << endl;
	cout << (getans(b) - getans(change(a))+10000) % 10000 << endl;
}

string change(string str){
	int len = str.size();
	for(int i=len-1;i>=0;i--){
		if(str[i] == '0') str[i] = '9';
		else {
			str[i]--;
			break;
		}
	}
	return (str);
}

int getans(string str){
	s = str;
	len = s.size();
	for(int i=0;i<2;i++){
		for(int j=0;j<3;j++){
			for(int k=0;k<10;k++){
				for(int l=0;l<500;l++){
					for(int p=0;p<500;p++){
						dp[i][j][k][l][p] = -1;
					}
				}
			}
		}
	}
	return bfs(false,0,0,0,0);
}

int bfs(bool flg,int pm,int num,int mod,int idx){
	if(idx == len) return mod == 0;
	if(dp[flg][pm][num][mod][idx] != -1) return dp[flg][pm][num][mod][idx];
	int ret = 0,end;
	if(flg) end = 9;
	else end = s[idx] - '0';
	for(int i=0;i<=end;i++){
		if(pm == 1 && num <= i) continue;
		if(pm == 2 && num >= i) continue;

		if(pm == 0){
			if(num && num == i) continue;
			if(num == 0) ret += bfs(flg|(i!=end),0,i,(mod*10+i)%M,idx+1);
			else if(num < i) ret += bfs(flg|(i!=end),1,i,(mod*10+i)%M,idx+1);
			else if(num > i) ret += bfs(flg|(i!=end),2,i,(mod*10+i)%M,idx+1);
		}
		else if(pm == 1){
			ret += bfs(flg|(i!=end),2,i,(mod*10+i)%M,idx+1);
		}
		else if(pm == 2){
			ret += bfs(flg|(i!=end),1,i,(mod*10+i)%M,idx+1);
		}
	}
	return dp[flg][pm][num][mod][idx] = ret % 10000;
}