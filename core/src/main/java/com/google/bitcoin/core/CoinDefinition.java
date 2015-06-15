package com.google.bitcoin.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Hash Engineering Solutions
 * Date: 5/3/14
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "Unpay";
    public static final String coinTicker = "UNP";
    public static final String coinURIScheme = "unpay";
    public static final String cryptsyMarketId = "155";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START = "[7X]";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;


    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://explorer.darkcoin.io/";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = BLOCKEXPLORER_BASE_URL_PROD;

    public static final String DONATION_ADDRESS = "Xdeh9YTLNtci5zSL4DDayRSVTLf299n9jv";  //Hash Engineering donation DASH address
    public static final String DONATION_ADDRESS_TESTNET = "";  //Hash Engineering donation DASH address

    enum CoinHash {
        SHA256,
        scrypt,
        x11
    };
    public static final CoinHash coinPOWHash = CoinHash.x11;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(24 * 60 * 60);  // 24 hours per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(2.5 * 60);  // 2.5 minutes seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //36 blocks

    public static final int getInterval(int height, boolean testNet) {
        return INTERVAL;      //108
    }
    public static final int getIntervalCheckpoints() {
        return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
        return TARGET_TIMESPAN;    //72 min
    }

    public static int spendableCoinbaseDepth = 100; //main.h: static const int COINBASE_MATURITY
    public static final BigInteger MAX_MONEY = BigInteger.valueOf(184467440737L).multiply(Utils.COIN);                 //main.h:  MAX_MONEY
    //public static final String MAX_MONEY_STRING = "200000000";     //main.h:  MAX_MONEY

    public static final BigInteger DEFAULT_MIN_TX_FEE = BigInteger.valueOf(100000);   // MIN_TX_FEE
    public static final BigInteger DUST_LIMIT = BigInteger.valueOf(1000); //main.h CTransaction::GetMinFee        0.01 coins

    public static final int PROTOCOL_VERSION = 70075;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70066;        //version.h MIN_PROTO_VERSION
    public static final int BIP0031_VERSION = 60000;

    public static final int BLOCK_CURRENTVERSION = 2;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 3338;       //chainparams.cpp nDefaultPort(testnet=false)
    public static final int TestPort = 13338;     //chainparams.cpp nDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 76;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 16;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final boolean allowBitcoinPrivateKey = false; //for backward compatibility with previous version of digitalcoin
    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long oldPacketMagic = 0xfbc0b6db;      //0xfb, 0xc0, 0xb6, 0xdb
    public static final long PacketMagic = 0xbf0c6bbd;

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1433994215L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (6337833);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "000003e14b723be4346c6ed7c61d46c7e6d6d83d4b1c3db38b2a38248d5a134c"; //main.cpp: hashGenesisBlock
    static public String genesisMerkleRoot = "b6df1d332acec3f426902d1ab6f981f9d69eeb07e5a78b8592f9ab9f3a1bbee0";
    static public int genesisBlockValue = 50;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    static public String genesisTxInBytes = "04ffff001d01044c9953696e6365204d617920323031352c207468652052657075626c6963206f66204b6f72656120686173206265656e20696e7665737469676174696e6720616e206f7574627265616b206f66204d4552532e20497420697320746865206c617267657374206b6e6f776e206f7574627265616b206f66204d455253206f75747369646520746865204172616269616e2050656e696e73756c612e";   //"Since May 2015, the Republic of Korea has been investigating an outbreak of MERS. It is the largest known outbreak of MERS outside the Arabian Peninsula."
    static public String genesisTxOutBytes = "04678afdb0fe5548271967f1a67130b7105cd6a828e03909a67962e0ea1f61deb649f6bc3f4cef38c4f35504e51ec112de5c384df7ba0b8d578a4c702b6bf11d5f";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "dnsseed.unpaybank.info",
//            "masternode.io",
//            "dnsseed.darkcoin.qa",
//            "23.23.186.131", //Evan's seed node
//            "162.252.83.46",  //drkpool.com
//            "107.155.71.72",
//            "50.16.206.102",
//            "50.19.116.123",
//            "98.165.130.67",
//            "23.23.186.131",
//            "50.16.206.102",
//            "50.19.116.123",
//            "50.19.116.123",
//            "23.21.204.34",
//            "188.142.39.105",
//            "50.16.206.102", //InternetApe's seed node
//            "23.23.186.131",
//            "50.19.116.123",
//            "54.248.227.151",
//            "42.121.58.91",
//            "50.81.192.39",
//            "54.193.124.32",
//            "62.141.39.175",
//            "5.254.96.3",
//            "175.115.201.44",
//            "208.53.191.2",
//            "162.243.33.16",
    };

    public static int minBroadcastConnections = 0;   //0 for default; we need more peers.

    //
    // TestNet - dimecoin - not tested
    //
    public static final boolean supportsTestNet = true;
    public static final int testnetAddressHeader = 139;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 19;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0xcee2caff;      //
    public static final String testnetGenesisHash = "00000890f1794585e882cbb9ec24760f2293fba338eb919232ff9c4f740267f4";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1433994530L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (72436);                         //main.cpp: LoadBlockIndex





    //main.cpp GetBlockValue(height, fee)
    public static final BigInteger GetBlockReward(int height)
    {
        int COIN = 1;
        BigInteger nSubsidy = Utils.toNanoCoins(100, 0);
        if (height == 1)
            nSubsidy = Utils.toNanoCoins(420000, 0);
        return nSubsidy;
    }

    public static int subsidyDecreaseBlockCount = 4730400;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
            "testnet-dnsseed.unpaybank.info",
//            "testnet-seed.darkcoin.io",
//            "testnet-seed.darkcoin.qa",
//            "23.23.186.131"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "048240a8748a80a286b270ba126705ced4f2ce5a7847b3610ea3c06513150dade2a8512ed5ea86320824683fc0818f0ac019214973e677acd1244f6d0571fc5103";
    public static final String TESTNET_SATOSHI_KEY = "04517d8a699cb43d3938d7b24faaff7cda448ca4ea267723ba614784de661949bf632d6304316b244646dea079735b9a6fc4af804efb4752075b9fe2245e14e412";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.unpaybank.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.unpaybank.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.unpaybank.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {

//        checkpoints.put(  1500, new Sha256Hash("000000aaf0300f59f49bc3e970bad15c11f961fe2347accffff19d96ec9778e3"));
//        checkpoints.put(  4991, new Sha256Hash("000000003b01809551952460744d5dbb8fcbd6cbae3c220267bf7fa43f837367"));
//        checkpoints.put(  9918, new Sha256Hash("00000000213e229f332c0ffbe34defdaa9e74de87f2d8d1f01af8d121c3c170b"));
//        checkpoints.put( 16912, new Sha256Hash("00000000075c0d10371d55a60634da70f197548dbbfa4123e12abfcbc5738af9"));
//        checkpoints.put( 23912, new Sha256Hash("0000000000335eac6703f3b1732ec8b2f89c3ba3a7889e5767b090556bb9a276"));
//        checkpoints.put( 35457, new Sha256Hash("0000000000b0ae211be59b048df14820475ad0dd53b9ff83b010f71a77342d9f"));
//        checkpoints.put( 45479, new Sha256Hash("000000000063d411655d590590e16960f15ceea4257122ac430c6fbe39fbf02d"));
//        checkpoints.put( 55895, new Sha256Hash("0000000000ae4c53a43639a4ca027282f69da9c67ba951768a20415b6439a2d7"));
//        checkpoints.put( 68899, new Sha256Hash("0000000000194ab4d3d9eeb1f2f792f21bb39ff767cb547fe977640f969d77b7"));
//        checkpoints.put( 74619, new Sha256Hash("000000000011d28f38f05d01650a502cc3f4d0e793fbc26e2a2ca71f07dc3842"));
//        checkpoints.put( 75095, new Sha256Hash("0000000000193d12f6ad352a9996ee58ef8bdc4946818a5fec5ce99c11b87f0d"));
//        checkpoints.put( 88805, new Sha256Hash("00000000001392f1652e9bf45cd8bc79dc60fe935277cd11538565b4a94fa85f"));
//        checkpoints.put( 90544, new Sha256Hash("000000000001b284b79a44a95215d7e6cf9e22cd4f9b562f2cc796e941e0e411"));
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "XgxQxd6B8iYgEEryemnJrpvoWZ3149MCkK";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "XDtvHyDHk4S3WJvwjxSANCpZiLLkKzoDnjrcRhca2iLQRtGEz1JZ";

}
