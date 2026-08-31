#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <cstring>

using namespace std;
int M;
int dp[2][501][11][2];
int dp2[2][501][11][2][2];
const int mod=10000;

bool isCheckCond(int firstUp,int pos,int prvDig,int curDig){
	bool ok=false;
	if(firstUp){
		if((pos%2)==1)ok=prvDig<curDig;
		else ok=prvDig>curDig;
	}
	else{
		if((pos%2)==0)ok=prvDig<curDig;
		else ok=prvDig>curDig;
	}
	return ok;
}
bool checkM(string &s){
	int sum=0;
	for(int i=0;i<(int)s.size();i++){
		sum+=s[i]-'0';
		sum%=M;
	}
	return (sum==0);
}
bool isZig(string &s){
	if(s.size()==1)return true;
	bool firstUp=(s[1]-s[0]>0);
	for(int i=1;i<(int)s.size();i++){
		bool ok=isCheckCond(firstUp,i,s[i-1]-'0',s[i]-'0');
		if(!ok)return false;
	}
	return true;
}

int solve1(int lastRank){
	for(int pos=lastRank-1;pos>=0;pos--){
		int nxt=pos%2;
		int prv=(pos+1)%2;
		for(int num=0;num<=500;num++){
			for(int prvDig=0;prvDig<10;prvDig++){
				for(int firstUp=0;firstUp<2;firstUp++){
					int res=0;
					if(pos==lastRank-1)res=((num%M)==0);
					else{
						// »ÝÌÓÉJÚÂ\Èç1ðÁZ
						res=((num%M)==0)&&(pos!=0);
						for(int i=0;i<=9;i++){
							// ÅÌª0ÅÍ¾ß
							if(pos==0&&i==0)continue;
							// OÌæèå«­ÈéÌÝJÚ
							bool ok=isCheckCond(firstUp,pos,prvDig,i);
							if(pos==0){
								res+=dp[prv][(i)%M][i][0];
								res%=mod;
								res+=dp[prv][(i)%M][i][1];
								if(i%M==0)res--;
							}
							else if(ok)res+=dp[prv][(num*10+i)%M][i][firstUp];
						}
					}
					dp[nxt][num][prvDig][firstUp]=res%mod;
				}
			}
		}
	}
	return dp[0][0][0][0]%mod;
}
int solve2(string &s,int lastRank){
	for(int pos=lastRank;pos>=0;pos--){
		int nxt=pos%2;
		int prv=(pos+1)%2;
		for(int num=0;num<=500;num++){
			for(int prvDig=0;prvDig<10;prvDig++){
				for(int firstUp=0;firstUp<2;firstUp++){
					for(int isSmaller=0;isSmaller<2;isSmaller++){
						int res=0;
						if(pos==lastRank)res=((num%M)==0);
						else{
							// »ÝÌÓÉJÚÂ\Èç1ðÁZ
							for(int i=0;i<=9;i++){
								// ÅÌª0ÅÍ¾ß
								if(pos==0&&i==0)continue;
								bool ok=isCheckCond(firstUp,pos,prvDig,i);
								// OÌæèå«­Èé,©Âsðz¦Ä¢È¢ÌÝJÚ
								if(pos==0){
									// ¡ñIðµ½ªÇÌöxÌå«³©
									if(s[pos]-'0'==i){
										res+=dp2[prv][(num*10+i)%M][i][0][0];
										res%=mod;
										res+=dp2[prv][(num*10+i)%M][i][1][0];
										res%=mod;
									}
									if(s[pos]-'0'>i){
										res+=dp2[prv][(num*10+i)%M][i][0][1];
										res%=mod;
										res+=dp2[prv][(num*10+i)%M][i][1][1];
										res%=mod;
									}
									else if(s[pos]-'0'<i)break;
								}
								else if(ok){
									if(isSmaller)res+=dp2[prv][(num*10+i)%M][i][firstUp][isSmaller];
									else{
										// ¯¶ÈçA»ÌÜÜ
										if(s[pos]-'0'==i)res+=dp2[prv][(num*10+i)%M][i][firstUp][isSmaller];
										// ¡ñIñ¾ªsÌæè¬³¢ÈçÎ
										else if(s[pos]-'0'>i)res+=dp2[prv][(num*10+i)%M][i][firstUp][1];
										else if(s[pos]-'0'<i)break;
									}
								}
							}
						}
						dp2[nxt][num][prvDig][firstUp][isSmaller]=res%mod;
					}
				}
			}
		}
	}
	return dp2[0][0][0][0][0]%mod;
}
int calc(string &A){
	int a=0;
	if(A.size()!=1){
		a=solve1(A.size());
	}
	int b=0;
	if(A.size()==1){
		for(int i=1;i<=A[0]-'0';i++)if((i%M)==0)b++;
	}
	else{
		b=solve2(A,A.size());
	}
	int res=(a+b)%mod;
	return res;
}
int main(){
	string A,B;
	cin>>A>>B>>M;
	// BÈºÌàÌ©çAÈºÌàÌðø­
	// AªàµWOUO©ÂMÌ{ÈçA»Ìªø­
	int a=calc(A);
	int b=calc(B);
	int res=(b-a+mod)%mod;
	if(isZig(A)&&checkM(A))res++;
	//	res%=mod;
	cout<<res<<endl;
	return 0;
}