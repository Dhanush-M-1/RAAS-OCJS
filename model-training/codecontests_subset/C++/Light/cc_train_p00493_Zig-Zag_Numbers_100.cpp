#include <cstdio>
#include <vector>
#include <bits/stdc++.h>

template<typename T>
void fill_all(T& i, const T& v){
	i = v;
}
template<typename U, typename T, size_t N>
void fill_all(T (&arr)[N], const U& v){
	for(auto& i : arr){
		fill_all(i, v);
	}
}

#if 1
int N=0;
char TOP[5010];
std::string BTM;
int BACE;
int16_t dp[2][2][2][12][2][500][1000];//is_zero, is_bef_less, is_bef_biger, ??´???, is_upper, ??´????????§???mod, i ??¶?´?????????????i??\??????????????°
int16_t func(bool is_zero, bool is_bef_less, bool is_bef_biger, int8_t bef, bool is_upper, int16_t mod, int16_t i);
int16_t func_run(bool is_zero, bool is_bef_less, bool is_bef_biger, int8_t bef, bool is_upper, int16_t mod, int16_t i)
{	
	#ifdef DEBUG
	std::cout << "in[" <<(is_zero?1:0)<<' '<<(is_bef_less?1:0)<<' '<<(is_bef_biger?1:0)<<' '<<(int)(bef)<<' '<<(is_upper?1:0)<<' '<<(mod)<<' '<<(i)<<"]\n";
	#endif
	
	auto call = [&](bool l,bool b, int8_t v){return func(false,l,b,v,!is_upper, (mod*10+v)%BACE, i+1);};
	int res = 0;
	int fend = 9;//[]????????¨???
	int fbegin = 0;
	if(is_zero)
	{
		//????°??????????????????????0????¶????
		if('0'==BTM[i]){res += func(true, true, false, 0, false, 0, i+1);}
		//0????????°??????????????????
		if(i<N-1){res += func(false, is_bef_less, is_bef_biger, -1, true, 0, i);}
		mod = 0;
		fend = 9; fbegin = 1;
	}
	else
	{
		if(is_upper){
			fbegin = bef + 1;
		}
		else{
			fend = bef - 1;
		}
	}
		
	if(!is_bef_less){
		//?????§???
		auto top = TOP[i]-'0';
		if(fbegin <= top && top <= fend){
			res += call(false, is_bef_biger||BTM[i]<TOP[i], top);
		}
		fend = std::min(fend, top-1);
	}
	if(!is_bef_biger){
		//????°????
		auto btm = BTM[i]-'0';
		if(fbegin <= btm && btm <= fend){
			res += call(is_bef_less||BTM[i]<TOP[i], false, btm);
		}
		fbegin = std::max(fbegin, btm+1);
	}
	for(int i = fbegin;i <= fend;++i){
		res += call(true, true, i);
	}
	
	#ifdef DEBUG
	std::cout << "out[" <<(is_zero?1:0)<<' '<<(is_bef_less?1:0)<<' '<<(is_bef_biger?1:0)<<' '<<(int)(bef)<<' '<<(is_upper?1:0)<<' '<<(mod)<<' '<<(i)<<"]\n";
	std::cout << "...res="<<res%10000<<"\n";
	#endif
	return (res%10000);
}
inline int16_t func(bool is_zero, bool is_bef_less, bool is_bef_biger, int8_t bef, bool is_upper, int16_t mod, int16_t i)
{
	if(i >= N){
		return (is_zero || mod%BACE)?0:1;
	}
	if(is_zero)
	{
		bef=0;is_upper=false;mod=0;
	}
	
	auto& memo = dp[is_zero?1:0][is_bef_less?1:0][is_bef_biger?1:0][bef+1][is_upper?1:0][mod][i];
	if(memo>=0){return memo;}
	return memo = func_run(is_zero, is_bef_less, is_bef_biger, bef, is_upper, mod, i);
}
int main()
{
	fill_all<int16_t>(dp,-1);
	std::cin >> BTM>>TOP>>BACE;
	
	while(TOP[N] != '\0'){++N;}
	BTM.insert(BTM.begin(), N-BTM.size(), '0');
	
	#ifdef DEBUG
	std::cout <<"BTM="<<BTM<<"\n";
	std::cout <<"TOP="<<TOP<<"\n";
	std::cout <<"N="<<N<<"\n";
	std::cout <<"BACE="<<BACE<<"\n";
	#endif
	int res = 0;
	res += func_run(true, false,false,0,false, 0, 0);
	std::cout << res%10000 << std::endl;
}
#endif