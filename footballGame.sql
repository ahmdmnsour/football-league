PGDMP         /                {           football    15.4    15.4 8    :           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ;           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            <           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            =           1262    16398    football    DATABASE     �   CREATE DATABASE football WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE football;
                postgres    false            �            1259    16452    coaches    TABLE     }   CREATE TABLE public.coaches (
    coach_id integer NOT NULL,
    name character varying(50) NOT NULL,
    team_id integer
);
    DROP TABLE public.coaches;
       public         heap    postgres    false            �            1259    16451    coach_coach_id_seq    SEQUENCE     �   CREATE SEQUENCE public.coach_coach_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.coach_coach_id_seq;
       public          postgres    false    217            >           0    0    coach_coach_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.coach_coach_id_seq OWNED BY public.coaches.coach_id;
          public          postgres    false    216            �            1259    16483    leagues    TABLE     q   CREATE TABLE public.leagues (
    league_id integer NOT NULL,
    league_name character varying(100) NOT NULL
);
    DROP TABLE public.leagues;
       public         heap    postgres    false            �            1259    16482    league_league_id_seq    SEQUENCE     �   CREATE SEQUENCE public.league_league_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.league_league_id_seq;
       public          postgres    false    223            ?           0    0    league_league_id_seq    SEQUENCE OWNED BY     N   ALTER SEQUENCE public.league_league_id_seq OWNED BY public.leagues.league_id;
          public          postgres    false    222            �            1259    16505    matches    TABLE     �   CREATE TABLE public.matches (
    match_id integer NOT NULL,
    home_team_id integer,
    away_team_id integer,
    match_date timestamp without time zone,
    home_team_goals integer,
    away_team_goals integer,
    winner_team_id integer
);
    DROP TABLE public.matches;
       public         heap    postgres    false            �            1259    16504    match_match_id_seq    SEQUENCE     �   CREATE SEQUENCE public.match_match_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.match_match_id_seq;
       public          postgres    false    226            @           0    0    match_match_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.match_match_id_seq OWNED BY public.matches.match_id;
          public          postgres    false    225            �            1259    16471    players    TABLE     ~   CREATE TABLE public.players (
    player_id integer NOT NULL,
    name character varying(50) NOT NULL,
    team_id integer
);
    DROP TABLE public.players;
       public         heap    postgres    false            �            1259    16470    player_player_id_seq    SEQUENCE     �   CREATE SEQUENCE public.player_player_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.player_player_id_seq;
       public          postgres    false    221            A           0    0    player_player_id_seq    SEQUENCE OWNED BY     N   ALTER SEQUENCE public.player_player_id_seq OWNED BY public.players.player_id;
          public          postgres    false    220            �            1259    16464    referees    TABLE     k   CREATE TABLE public.referees (
    referee_id integer NOT NULL,
    name character varying(50) NOT NULL
);
    DROP TABLE public.referees;
       public         heap    postgres    false            �            1259    16463    referee_referee_id_seq    SEQUENCE     �   CREATE SEQUENCE public.referee_referee_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.referee_referee_id_seq;
       public          postgres    false    219            B           0    0    referee_referee_id_seq    SEQUENCE OWNED BY     R   ALTER SEQUENCE public.referee_referee_id_seq OWNED BY public.referees.referee_id;
          public          postgres    false    218            �            1259    16489    team_league    TABLE     b   CREATE TABLE public.team_league (
    team_id integer NOT NULL,
    league_id integer NOT NULL
);
    DROP TABLE public.team_league;
       public         heap    postgres    false            �            1259    16445    teams    TABLE     k   CREATE TABLE public.teams (
    team_id integer NOT NULL,
    team_name character varying(100) NOT NULL
);
    DROP TABLE public.teams;
       public         heap    postgres    false            �            1259    16444    team_team_id_seq    SEQUENCE     �   CREATE SEQUENCE public.team_team_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.team_team_id_seq;
       public          postgres    false    215            C           0    0    team_team_id_seq    SEQUENCE OWNED BY     F   ALTER SEQUENCE public.team_team_id_seq OWNED BY public.teams.team_id;
          public          postgres    false    214            �           2604    16455    coaches coach_id    DEFAULT     r   ALTER TABLE ONLY public.coaches ALTER COLUMN coach_id SET DEFAULT nextval('public.coach_coach_id_seq'::regclass);
 ?   ALTER TABLE public.coaches ALTER COLUMN coach_id DROP DEFAULT;
       public          postgres    false    216    217    217            �           2604    16486    leagues league_id    DEFAULT     u   ALTER TABLE ONLY public.leagues ALTER COLUMN league_id SET DEFAULT nextval('public.league_league_id_seq'::regclass);
 @   ALTER TABLE public.leagues ALTER COLUMN league_id DROP DEFAULT;
       public          postgres    false    223    222    223            �           2604    16508    matches match_id    DEFAULT     r   ALTER TABLE ONLY public.matches ALTER COLUMN match_id SET DEFAULT nextval('public.match_match_id_seq'::regclass);
 ?   ALTER TABLE public.matches ALTER COLUMN match_id DROP DEFAULT;
       public          postgres    false    225    226    226            �           2604    16474    players player_id    DEFAULT     u   ALTER TABLE ONLY public.players ALTER COLUMN player_id SET DEFAULT nextval('public.player_player_id_seq'::regclass);
 @   ALTER TABLE public.players ALTER COLUMN player_id DROP DEFAULT;
       public          postgres    false    220    221    221            �           2604    16467    referees referee_id    DEFAULT     y   ALTER TABLE ONLY public.referees ALTER COLUMN referee_id SET DEFAULT nextval('public.referee_referee_id_seq'::regclass);
 B   ALTER TABLE public.referees ALTER COLUMN referee_id DROP DEFAULT;
       public          postgres    false    218    219    219            �           2604    16448    teams team_id    DEFAULT     m   ALTER TABLE ONLY public.teams ALTER COLUMN team_id SET DEFAULT nextval('public.team_team_id_seq'::regclass);
 <   ALTER TABLE public.teams ALTER COLUMN team_id DROP DEFAULT;
       public          postgres    false    215    214    215            .          0    16452    coaches 
   TABLE DATA           :   COPY public.coaches (coach_id, name, team_id) FROM stdin;
    public          postgres    false    217   b>       4          0    16483    leagues 
   TABLE DATA           9   COPY public.leagues (league_id, league_name) FROM stdin;
    public          postgres    false    223   �>       7          0    16505    matches 
   TABLE DATA           �   COPY public.matches (match_id, home_team_id, away_team_id, match_date, home_team_goals, away_team_goals, winner_team_id) FROM stdin;
    public          postgres    false    226   �>       2          0    16471    players 
   TABLE DATA           ;   COPY public.players (player_id, name, team_id) FROM stdin;
    public          postgres    false    221   (?       0          0    16464    referees 
   TABLE DATA           4   COPY public.referees (referee_id, name) FROM stdin;
    public          postgres    false    219   �?       5          0    16489    team_league 
   TABLE DATA           9   COPY public.team_league (team_id, league_id) FROM stdin;
    public          postgres    false    224   �?       ,          0    16445    teams 
   TABLE DATA           3   COPY public.teams (team_id, team_name) FROM stdin;
    public          postgres    false    215   @       D           0    0    coach_coach_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.coach_coach_id_seq', 3, true);
          public          postgres    false    216            E           0    0    league_league_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.league_league_id_seq', 1, true);
          public          postgres    false    222            F           0    0    match_match_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.match_match_id_seq', 2, true);
          public          postgres    false    225            G           0    0    player_player_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.player_player_id_seq', 6, true);
          public          postgres    false    220            H           0    0    referee_referee_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.referee_referee_id_seq', 2, true);
          public          postgres    false    218            I           0    0    team_team_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.team_team_id_seq', 15, true);
          public          postgres    false    214            �           2606    16457    coaches coach_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.coaches
    ADD CONSTRAINT coach_pkey PRIMARY KEY (coach_id);
 <   ALTER TABLE ONLY public.coaches DROP CONSTRAINT coach_pkey;
       public            postgres    false    217            �           2606    16488    leagues league_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.leagues
    ADD CONSTRAINT league_pkey PRIMARY KEY (league_id);
 =   ALTER TABLE ONLY public.leagues DROP CONSTRAINT league_pkey;
       public            postgres    false    223            �           2606    16510    matches match_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.matches
    ADD CONSTRAINT match_pkey PRIMARY KEY (match_id);
 <   ALTER TABLE ONLY public.matches DROP CONSTRAINT match_pkey;
       public            postgres    false    226            �           2606    16476    players player_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.players
    ADD CONSTRAINT player_pkey PRIMARY KEY (player_id);
 =   ALTER TABLE ONLY public.players DROP CONSTRAINT player_pkey;
       public            postgres    false    221            �           2606    16469    referees referee_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.referees
    ADD CONSTRAINT referee_pkey PRIMARY KEY (referee_id);
 ?   ALTER TABLE ONLY public.referees DROP CONSTRAINT referee_pkey;
       public            postgres    false    219            �           2606    16493    team_league team_league_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.team_league
    ADD CONSTRAINT team_league_pkey PRIMARY KEY (team_id, league_id);
 F   ALTER TABLE ONLY public.team_league DROP CONSTRAINT team_league_pkey;
       public            postgres    false    224    224            �           2606    16450    teams team_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.teams
    ADD CONSTRAINT team_pkey PRIMARY KEY (team_id);
 9   ALTER TABLE ONLY public.teams DROP CONSTRAINT team_pkey;
       public            postgres    false    215            �           2606    16458    coaches coach_team_id_fkey    FK CONSTRAINT     ~   ALTER TABLE ONLY public.coaches
    ADD CONSTRAINT coach_team_id_fkey FOREIGN KEY (team_id) REFERENCES public.teams(team_id);
 D   ALTER TABLE ONLY public.coaches DROP CONSTRAINT coach_team_id_fkey;
       public          postgres    false    215    3209    217            �           2606    16516    matches match_away_team_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.matches
    ADD CONSTRAINT match_away_team_id_fkey FOREIGN KEY (away_team_id) REFERENCES public.teams(team_id);
 I   ALTER TABLE ONLY public.matches DROP CONSTRAINT match_away_team_id_fkey;
       public          postgres    false    226    3209    215            �           2606    16511    matches match_home_team_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.matches
    ADD CONSTRAINT match_home_team_id_fkey FOREIGN KEY (home_team_id) REFERENCES public.teams(team_id);
 I   ALTER TABLE ONLY public.matches DROP CONSTRAINT match_home_team_id_fkey;
       public          postgres    false    3209    215    226            �           2606    16521 !   matches match_winner_team_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.matches
    ADD CONSTRAINT match_winner_team_id_fkey FOREIGN KEY (winner_team_id) REFERENCES public.teams(team_id);
 K   ALTER TABLE ONLY public.matches DROP CONSTRAINT match_winner_team_id_fkey;
       public          postgres    false    3209    226    215            �           2606    16477    players player_team_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY public.players
    ADD CONSTRAINT player_team_id_fkey FOREIGN KEY (team_id) REFERENCES public.teams(team_id);
 E   ALTER TABLE ONLY public.players DROP CONSTRAINT player_team_id_fkey;
       public          postgres    false    215    3209    221            �           2606    16499 &   team_league team_league_league_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.team_league
    ADD CONSTRAINT team_league_league_id_fkey FOREIGN KEY (league_id) REFERENCES public.leagues(league_id);
 P   ALTER TABLE ONLY public.team_league DROP CONSTRAINT team_league_league_id_fkey;
       public          postgres    false    3217    224    223            �           2606    16494 $   team_league team_league_team_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.team_league
    ADD CONSTRAINT team_league_team_id_fkey FOREIGN KEY (team_id) REFERENCES public.teams(team_id);
 N   ALTER TABLE ONLY public.team_league DROP CONSTRAINT team_league_team_id_fkey;
       public          postgres    false    3209    224    215            .   5   x�3����/(�44�2��O�H-)����44�2�I�S�HL�44����� �<      4      x�3�(J��L-R�IML/M����� O$4      7   C   x�]���0�7Ta�p�QH-���{
��9�� .p߶��(Y�:���";fVLy������D�      2   u   x��M
�@�ur��@�s�R� ])�q�ACmg ڂ=���-^��_�1��J��#5��$'��8�;cA7��f����B�%�i¢�\0c�T�&6��N�⚮�$��3��3� P9"      0   &   x�3���M,R�L̨L�2����NUpIM������ �!�      5      x�34�4�24�@"F��� ��      ,   :   x�34��M�K�H-.I-R��,IM�24���,K-*����24�t�H�)NM����� �I     