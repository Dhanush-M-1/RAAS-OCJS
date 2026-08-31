#include <stdio.h>
#include <cmath>
#include <algorithm>
#include <cfloat>
#include <stack>
#include <queue>
#include <vector>
#include <string>
#include <iostream>
#include <set>
#include <map>
#include <time.h>
typedef long long int ll;
typedef unsigned long long int ull;
#define BIG_NUM 2000000000
#define MOD 1000000007
#define EPS 0.000000001
using namespace std;


#define NUM 10000

enum Type{
	LIMITED,
	NO_LIMIT,
};

enum DIR{
	UP,
	DOWN,
	NONE,
};

enum WHICH{
	A,
	B,
};

char buf[502];
int ARRAY[2][502],len[2],M;
int dp[2][502][2][2][10][500];


int calc(WHICH which,int digit,Type type,DIR dir,int pre_num,int pre_mod,bool zero_FLG){

	if(digit == len[which]){
		if(zero_FLG){
			return 0;
		}else{
			if(pre_mod == 0){
				return 1;
			}else{
				return 0;
			}
		}
	}

	if(zero_FLG){

		int ret = 0;
		ret += calc(which,digit+1,NO_LIMIT,NONE,0,0,true);

		for(int num = 1; num <= 9; num++){
			ret += calc(which,digit+1,NO_LIMIT,UP,num,num%M,false);
			if(digit+1 < len[which]){
				ret += calc(which,digit+1,NO_LIMIT,DOWN,num,num%M,false);
			}
		}
		return ret%NUM;
	}

	if(dp[which][digit][type][dir][pre_num][pre_mod] != -1)return dp[which][digit][type][dir][pre_num][pre_mod];

	int ret = 0;

	if(type == LIMITED){

		if(dir == UP){

			for(int num = pre_num+1; num <= ARRAY[which][digit]; num++){

				if(num < ARRAY[which][digit]){
					ret += calc(which,digit+1,NO_LIMIT,DOWN,num,(10*pre_mod+num)%M,false);
				}else{
					ret += calc(which,digit+1,LIMITED,DOWN,num,(10*pre_mod+num)%M,false);
				}
			}

		}else{

			for(int num = 0; num <= min(pre_num-1,ARRAY[which][digit]); num++){
				if(num < ARRAY[which][digit]){
					ret += calc(which,digit+1,NO_LIMIT,UP,num,(10*pre_mod+num)%M,false);
				}else{
					ret += calc(which,digit+1,LIMITED,UP,num,(10*pre_mod+num)%M,false);
				}
			}
		}

	}else{
		if(dir == UP){
			for(int num = pre_num+1; num <= 9; num++){
				ret += calc(which,digit+1,NO_LIMIT,DOWN,num,(10*pre_mod+num)%M,false);
			}

		}else{

			for(int num = 0; num <= pre_num-1; num++){
				ret += calc(which,digit+1,NO_LIMIT,UP,num,(10*pre_mod+num)%M,false);
			}
		}
	}

	return dp[which][digit][type][dir][pre_num][pre_mod] = ret%NUM;
}

int func(WHICH which){

	for(int length = 0; length <= len[which]; length++){
		for(int a = 0; a <= 1; a++){
			for(int b = 0; b <= 1; b++){
				for(int num = 0; num <= 9; num++){
					for(int mod = 0; mod <= M-1; mod++){
						dp[which][length][a][b][num][mod] = -1;
					}
				}
			}
		}
	}

	int ret = 0;
	ret += calc(which,1,NO_LIMIT,NONE,0,0,true);

	for(int head_num = 1; head_num <= ARRAY[which][0]; head_num++){
		if(head_num == ARRAY[which][0]){
			ret += calc(which,1,LIMITED,UP,head_num,head_num%M,false);
			if(len[which] > 1){
				ret += calc(which,1,LIMITED,DOWN,head_num,head_num%M,false);
			}
		}else{
			ret += calc(which,1,NO_LIMIT,UP,head_num,head_num%M,false);
			if(len[which] > 1){
				ret += calc(which,1,NO_LIMIT,DOWN,head_num,head_num%M,false);
			}
		}
	}

	return ret%NUM;
}

bool is_A_zigzag(){

	if(len[A] == 1){
		if(ARRAY[A][0] > 0){
			return true;
		}else{
			return false;
		}
	}

	for(int digit = 0; digit < len[A]-1; digit++){
		if(ARRAY[A][digit] == ARRAY[A][digit+1])return false;
	}

	DIR dir;
	if(ARRAY[A][0] > ARRAY[A][1]){
		dir = DOWN;
	}else{
		dir = UP;
	}

	for(int digit = 1; digit < len[A]-1; digit++){
		if(ARRAY[A][digit] > ARRAY[A][digit+1]){
			if(dir == DOWN)return false;
			dir = DOWN;
		}else if(ARRAY[A][digit] < ARRAY[A][digit+1]){
			if(dir == UP)return false;
			dir = UP;
		}
	}

	return true;
}

int main(){

	scanf("%s",buf);
	for(len[A] = 0; buf[len[A]] != '\0'; len[A]++){
		ARRAY[A][len[A]] = buf[len[A]]-'0';
	}
	scanf("%s",buf);
	for(len[B] = 0; buf[len[B]] != '\0'; len[B]++){
		ARRAY[B][len[B]] = buf[len[B]]-'0';
	}

	scanf("%d",&M);

	int minus_A = 0;
	if(is_A_zigzag()){
		minus_A = 1;
	}

	printf("%d\n",(func(B)-(func(A)-minus_A)+NUM)%NUM);

	return 0;
}

